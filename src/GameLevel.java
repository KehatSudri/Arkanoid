/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.List;
import java.util.Random;


/**
 * class of the game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //private GUI gui;
    private Counter blockCounter, ballCounter, scoreCounter, lives;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Paddle pad;


    /**
     * costructor for Game.
     *
     * @param levelInformation levelInformation
     * @param animationRunner  animationRunner
     * @param ks               keyboard sensor
     * @param score            score counter
     * @param lives            lives counter
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner,
                     KeyboardSensor ks, Counter score, Counter lives) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.scoreCounter = score;
        this.runner = animationRunner;
        this.keyboard = ks;
        this.levelInformation = levelInformation;
        this.lives = lives;


    }

    /**
     * add collidable.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }


    /**
     * remove collidable from the game.
     *
     * @param c the collidable we want remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove Sprite from the game.
     *
     * @param s the Sprite we want remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * add Sprite.
     *
     * @param s Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * add paddle.
     */
    public void addPaddle() {
        Point p6 = new Point(400 - (levelInformation.paddleWidth() / 2), 595);
        Rectangle paddleRec = new Rectangle(p6, levelInformation.paddleWidth(), 5);
        Paddle p = new Paddle(paddleRec, this.keyboard, levelInformation.paddleSpeed());
        this.pad = p;
        p.addToGame(this);

    }

    /**
     * center the paddle.
     */
    public void centerPaddle() {
        Point p6 = new Point(400 - (levelInformation.paddleWidth() / 2), 595);
        Rectangle paddleRec = new Rectangle(p6, levelInformation.paddleWidth(), 5);
        this.pad.setPlace(paddleRec);
    }

    /**
     * add balls to the game.
     */
    public void addBalls() {
        Random r = new Random();
        List<Velocity> velocityList = levelInformation.initialBallVelocities();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 587, 7, java.awt.Color.BLACK);
            ball.setVelocity(velocityList.get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            ballCounter.increase(1);
        }
    }

    /**
     * @return the balls counter value.
     */
    public Counter getBallsCounter() {
        return this.ballCounter;
    }

    /**
     * @return the lives counter value.
     */
    public Counter getLives() {
        return this.lives;
    }

    /**
     * @return the blocks counter value.
     */
    public Counter getBlocksCounter() {
        return this.blockCounter;
    }


    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle).
     * and add them to the game.
     */
    public void initialize() {


        addPaddle();
        addBalls();
        BlockRemover pp1 = new BlockRemover(this, blockCounter);
        BallRemover bb1 = new BallRemover(this, ballCounter);
        ScoreTrackingListener scl = new ScoreTrackingListener(scoreCounter);

        Rectangle rr = (new Rectangle(new Point(0, 0), 800, 15, Color.white));
        Block bb = new Block(rr);
        bb.addToGame(this);

        ScoreIndicator scoreIndicator = new ScoreIndicator(scl);
        scoreIndicator.addToGame(this);
        LevelNameIndicator levelNameIndicator = new LevelNameIndicator(scl, levelInformation.levelName());
        levelNameIndicator.addToGame(this);

        LivesIndicator livesIndicator = new LivesIndicator(scl, lives);
        livesIndicator.addToGame(this);


        Point p2 = new Point(0, 15);
        Rectangle r2 = new Rectangle(p2, 800, 2, Color.darkGray);
        Point p3 = new Point(15, 15);
        Rectangle r3 = new Rectangle(p3, 2, 585, Color.darkGray);
        Point p4 = new Point(783, 15);
        Rectangle r4 = new Rectangle(p4, 2, 585, Color.darkGray);
        Point p5 = new Point(0, 600);
        Rectangle r5 = new Rectangle(p5, 800, 2, Color.gray);


        Block b2 = new Block(r2);
        Block b3 = new Block(r3);
        Block b4 = new Block(r4);
        Block b5 = new Block(r5);
        b5.addHitListener(bb1);

        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);
        b5.addToGame(this);


        List<Block> blockList = levelInformation.blocks();
        for (int i = 0; i < blockList.size(); i++) {
            blockList.get(i).addToGame(this);
            blockList.get(i).addHitListener(pp1);
            blockList.get(i).addHitListener(scl);
            blockCounter.increase(1);
        }
    }


    /**
     * Run the game -- start the animation loop.
     */
    public void run() {

        this.runner.run(new CountdownAnimation(2, 3, sprites, levelInformation));
        this.running = true;
        this.runner.run(this);


    }

    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        levelInformation.drawLevel(d);
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;


        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        // timing
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "Pause",
                    new PauseScreen(this.keyboard), scoreCounter));
        }
        if (ballCounter.getValue() == 0) {
            System.out.println("Your score : " + scoreCounter.getValue() + " !!");
            running = false;
        }


        if (blockCounter.getValue() == 0) {
            scoreCounter.increase(100);
            System.out.println("Your score : " + scoreCounter.getValue() + " !!");
            running = false;


        }
    }

    /**
     * check if ani,ation should stop.
     *
     * @return T or F
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
