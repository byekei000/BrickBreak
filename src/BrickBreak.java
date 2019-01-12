import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreak extends JPanel implements KeyListener, ActionListener {

    private int width;
    private int height;
    private int ballX = 300;
    private int ballY = 300;
    private int ballDX = 1;
    private int ballDY = -1;
    private int ballSpeed = 5;
    private int racketDirection = 0;
    private int racketX;
    private Timer timer;

    public BrickBreak(int width, int height) {
        this.width = width;
        this.height = height;
        racketX = width / 2;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(17, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);
        //ball
        g.setColor(Color.CYAN);
        g.fillOval(ballX, ballY, 20, 20);
        //racket
        g.setColor(Color.green);
        g.fillRect(racketX, height-50, 100,10);
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void actionPerformed(ActionEvent e) {
        if (ballDX == 1) {
            ballX += ballSpeed;
        } else ballX -= ballSpeed;
        if (ballDY == 1) {
            ballY += ballSpeed;
        } else ballY -= ballSpeed;
        if (ballX > width - 20 || ballX < 0) {
            ballDX = -ballDX;
        }
        if (ballY < 0) {
            ballDY = -ballDY;
        }
        if(racketDirection == 1){
            racketX += 10;
        }
        if(racketDirection == -1){
            racketX -= 10;
        }
        if(racketX > width - 100){
            racketX = width - 100;
        }
        if(racketX < 0){
            racketX = 0;
        }
        if(new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(racketX, height-50, 100,10))){
            ballDY = -1;
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            racketDirection = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            racketDirection = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            racketDirection = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            racketDirection = 0;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}
