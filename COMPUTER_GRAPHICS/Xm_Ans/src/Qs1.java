import java.awt.*;
import java.awt.event.MouseWheelEvent;
import javax.swing.*;

public class Qs1 extends JPanel {
    private static final int RECT_X = 20;
    private static final int RECT_Y = RECT_X;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_HEIGHT = RECT_WIDTH;

    private static final int PANEL_WIDTH = 1000;
    private static final int PANEL_HIGHT = 500;


    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1000,1000 );

        g.setColor(Color.green);
        g.drawString("Normal", RECT_X, RECT_Y-5);
        g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);

        //translation
        g.setColor(Color.YELLOW);
        int translationX = RECT_WIDTH+50 , translationY = 150;
        g.drawString("Translation", RECT_X+translationX, RECT_Y-5);
        g.drawRect(RECT_X+translationX, RECT_Y+translationY, RECT_WIDTH, RECT_HEIGHT);

        //Scaling
        g.setColor(Color.WHITE);
        g.drawString("Scaling", RECT_X+RECT_WIDTH+120, RECT_Y-5);
        double scale = 0.5  ;
        g.drawRect(RECT_X+RECT_WIDTH+120, RECT_Y, (int)(RECT_WIDTH*scale), (int)(RECT_HEIGHT*scale));

        //Rotation
        g.setColor(Color.ORANGE);
        g.drawString("Rotation", RECT_X+RECT_WIDTH+200, RECT_Y-5);
        double angle = 45.0;
        Rectangle rect = new Rectangle(RECT_X+RECT_WIDTH+150, RECT_Y-250, RECT_WIDTH, RECT_HEIGHT);
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(angle));

        g2d.draw(rect);



    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_WIDTH, PANEL_HIGHT );
    }

    private static void createAndShowGui() {
        Qs1 mainPanel = new Qs1();

        JFrame frame = new JFrame("Qs1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}