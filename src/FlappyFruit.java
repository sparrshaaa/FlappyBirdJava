import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //store all pipes
import java.util.Random; //placing the pipes in random position
import javax.swing.*;

public class FlappyFruit extends JPanel implements ActionListener{
    int boardWidth = 360;
    int boardHeight = 640;
// these variables will store image objects
    Image backgroundImg;
    Image fruitImg;
    Image topPipeImg;
    Image bottomPipeImg;

//fruit
    int fruitx = boardWidth/8; //position it 
    int fruity = boardHeight/2;
    // fruit dimensions
    int fruitWidth = 34;
    int fruitHeight = 24;

    // make it as class for easy access
    class Fruit{
        int x = fruitx;
        int y = fruity;
        int width = fruitWidth;
        int height = fruitHeight;
        Image img; 

        Fruit(Image img){ // a constructor
            this.img = img; // assign image to fruit
        }

    }
//game logic
    Fruit fruit; 
    // make fruit move
    int velocityY = -6; 
    int gravity = 1;
    Timer gameLoop;

    FlappyFruit(){ // need a consturctor
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // to use existing dimension
        setBackground(Color.blue);

        //load images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        // within src from the class it gets image resource in image form
        fruitImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //fruit
        fruit = new Fruit(fruitImg); 

        //game timer 
        gameLoop = new Timer(1000/60, this); //1000/60=16.6
        //this- refers to flappyfruit class
        gameLoop.start(); //start timer

    }
    public void paintComponent(Graphics g) {
		super.paintComponent(g); //here super class is jpanel
		draw(g);
	}
    public void draw(Graphics g) {
        System.out.println("draw"); // just to text
        //background
        g.drawImage(backgroundImg, 0, 0, this.boardWidth, this.boardHeight, null);
        g.drawImage(fruit.img, fruitx, fruity, fruit.width, fruit.height,null );
    }

    public void move(){
        //fruit
        velocityY+=gravity;
        fruit.y+=velocityY;
        fruit.y=Math.max(fruit.y,0); //to not go outofframe
         
    }
    @Override
    //what action is perfeorms as per timer
    public void actionPerformed(ActionEvent e) {
        move(); // to move fruit position
        repaint(); // it calls draw again
    }
}
