//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener {


    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;
int crashCounter;
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image astroPic;
    public Image background;
    public Image emojiPic;

    public Image bunnyPic;

    public Image bugPic;

    public Image dogPic;

    public Image catPic;

    public Image spiderPic;

    public Image caterPic;

    public Image buttonPic;


    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    private Astronaut astro;
    private Astronaut jack;

    private Astronaut emoji;

    private Astronaut bunny;

    private Astronaut bug;

    private Astronaut dog;

    private Astronaut cat;

    private Astronaut spider;

    private Astronaut cater;

    private Astronaut button;
    private Astronaut[] emojis;


    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();//creates a threads & starts up the code in the run( ) method
        //if crashes = 5
        //then end screen shows up
    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {


        setUpGraphics();
        canvas.addKeyListener(this);
//        for(x int x=0; x<)

        //variable and objects
        //create (construct) the objects needed for the game and load up
        astroPic = Toolkit.getDefaultToolkit().getImage("babybees.jpg"); //load the picture
        emojiPic = Toolkit.getDefaultToolkit().getImage("butterfly.jpg"); //load the picture
        bunnyPic = Toolkit.getDefaultToolkit().getImage("bunny.png"); //load the picture
        bugPic = Toolkit.getDefaultToolkit().getImage("bug.jpg"); //load the picture
        dogPic =Toolkit.getDefaultToolkit().getImage("dog.jpeg"); //load the picture
        catPic = Toolkit.getDefaultToolkit().getImage("cat.png"); //load the picture
        spiderPic= Toolkit.getDefaultToolkit().getImage("spider.jpeg"); //load the picture
        caterPic= Toolkit.getDefaultToolkit().getImage("caterpillar.jpeg"); //load the picture
        buttonPic= Toolkit.getDefaultToolkit().getImage("caterpillar.jpeg"); //load the picture
        background = Toolkit.getDefaultToolkit().getImage("bees.png"); //load the picture
        astro = new Astronaut((int)(Math.random()*900)+10, 100);
        jack = new Astronaut( (int)(Math.random()*900)+12, 100);
        emoji = new Astronaut(320, 100);
        emojis= new Astronaut[10];//construct the array to hold the astro is it empty
        for(int x=0;x<emojis.length;x++){
            emojis[x]=new Astronaut((int)(300*Math.random()), x*200); //fill each slot
        }

        bunny = new Astronaut(420, 100);
        bug = new Astronaut(540, 100);
        dog = new Astronaut(660, 100);
        cat = new Astronaut(720, 100);
        spider= new Astronaut(840, 100);
        cater= new Astronaut(870, 100);
        button= new Astronaut(700, 300);
        bunny.dy = 4;
        bunny.dx = 6;
        bug.dx=5;
        bug.dy=6;
        jack.dy = 3;
        jack.dx = -1;
        astro.dx= 7;
        astro.dy=2;
        spider.dy = 5;
        spider.dx=-1;


//public void Array babybees
//        for (int  t=0; t< babybees.size(); t++){
//            for (int a=0; a< babybees.length); a++){
//                if (babybees) ;
//
//
//            }
//            }
        }



    // BasicGameApp()

    public void crash() {

        if (astro.rec.intersects(jack.rec)&& astro.isCrashing==false)
        {
            emojiPic = dogPic;
           // bugPic = catPic;
            System.out.println("crash");
            astro.dx = -1 * astro.dx;
            astro.dy = -astro.dy;
            jack.dx = -1 * jack.dx;
             crashCounter++;
            //jack.dy = -jack.dy;
            //jack.isAlive = false;



            }

        if(!astro.rec.intersects(jack.rec))
        {
          //when true
            astro.isCrashing=false;
        }

        }

        public void wrap(){
       for(int x=0; x<1001; x++){
           bug.dx= x;
           x++;
           if(bug.dx >HEIGHT){
               bug.dx=0;
           }
       }




        }













//		System.out. println("crash");
//		astro.dx = 1*astro.dx;
//		astro.dy = -astro.dy;
//		emoji.dx = -1*emoji.dx;
//		emoji.dy = -emoji.dy;
//		jack.dx = -1 *astro.dx;
//		jack.dy= jack.dy;
    //bunny.dy= bunny.dy;
   // bug.dy=bunny.dy


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up


    //for the moment we will loop things forever.


	public void run() {

		//for the moment we will loop things forever.
		while (true) {

			moveThings();  //move all the game objects
			render();  // paint the graphics
			pause(10); // sleep for 10 ms
		}
	}
//
//
//
//


    public void moveThings() {
        //calls the move( ) code in the objects
        astro.Bounce();
        jack.Bounce();
        emoji.Bounce();
        bunny.Bounce();
        spider.Bounce();
        dog.wrap();
        cat.Bounce();
        cater.Bounce();
        bug.wrap();
        crash();
        wrap();


    }


    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }


    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of the astronaut
        g.drawImage(background, 0, 0, 1000, 700, null);
        g.drawImage(astroPic, astro.xpos, astro.ypos, astro.width, astro.height, null);
        if (jack.isAlive == true) {
            g.drawImage(astroPic, jack.xpos, jack.ypos, jack.width, jack.height, null);
            g.draw(new Rectangle(jack.xpos, jack.ypos, jack.width, jack.height));

            g.drawImage(bunnyPic, bunny.xpos, bunny.ypos, bunny.width, bunny.height, null);
            g.draw(new Rectangle(bunny.xpos, bunny.ypos, bunny.width, bunny.height));

            g.drawImage(bugPic, bug.xpos, bug.ypos, bug.width, bug.height, null);
            g.draw(new Rectangle(bug.xpos, bug.ypos, bug.width, bug.height));

            g.drawImage(spiderPic, spider.xpos, spider.ypos, spider.width, spider.height, null);
            g.draw(new Rectangle(spider.xpos, spider.ypos, spider.width, spider.height));

        }

        pause(2);



        g.drawImage(emojiPic, emoji.xpos, emoji.ypos, emoji.width, emoji.height, null);

        g.draw(new Rectangle(astro.xpos, astro.ypos, astro.width, astro.height));
        g.draw(new Rectangle(emoji.xpos, emoji.ypos, emoji.width, emoji.height));
        g.draw(new Rectangle(bunny.xpos, bunny.ypos, bunny.width, bunny.height));
        g.draw(new Rectangle(bug.xpos, bug.ypos, bug.width, bug.height));
        g.draw(new Rectangle(spider.xpos,spider.ypos,spider.width,spider.height));

        if(crashCounter>10) {
            g.draw(new Rectangle(500, 500, 300, 300));
            g.setFont(new Font("Arial", 10,100));
            g.drawString("Game over :(", 200, 200);
            g.dispose();
        }


        bufferStrategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 68) {

            //-bunny.dy = 50;
        }
        if (code == 65) {
            bunny.dx = 88;
        }
        if (code == 40) {
            bunny.dx = 89;
        }

                if (code == 40) {
                    bunny.dx = 89;

                }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


//    Math.abs(code)


}
//
//public void
//    for (int t=0; t<)