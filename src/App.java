import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth=360;
        int boardHeight=640;

        JFrame frame = new JFrame("Flying Fruit");
       // frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null); //center of screen
        frame.setResizable(false); //user cant resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlappyFruit flappyFruit = new FlappyFruit(); //creating instance to use JPanel
        frame.add(flappyFruit);
        frame.pack(); // to ignore the dimensions of title bar
        //flappyFruit.requestFocus();
        frame.setVisible(true);
        
    }
}
