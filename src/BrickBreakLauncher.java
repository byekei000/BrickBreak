import javax.swing.*;

public class BrickBreakLauncher {

    public static void main(String[] args){
        int width = 800;
        int height = 600;

        JFrame frame = new JFrame("Brick Break");
        BrickBreak game = new BrickBreak(width, height);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
