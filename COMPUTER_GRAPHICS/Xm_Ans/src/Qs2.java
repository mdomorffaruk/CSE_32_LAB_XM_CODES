import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.lang.Math;

public class Qs2 extends Applet {

    void sleep()
    {
        try {
            Thread.sleep(15);
            repaint();
        }
        catch (Exception ob) {
        }
    }

    // Paint method
    public void paint(Graphics g)
    {



        int[] x = new int[] { 100, 150, 650, 700 };
        int[] y = new int[] { 500, 100, 100, 500 };

        int[] lx = new int[1200];
        int[] ly = new int[1200];
        int[] qlx = new int[1200];
        int[] qly = new int[1200];
        int[] llx = new int[1200];
        int[] lly = new int[1200];


        int[] xy = new int[10];
        double t;
        int nx, ny, i = 0;


        for (t = 0.0; t <= 1.0; t += 0.01) {
            //cubic
            lx[i] = (int)(Math.pow(1 - t, 3) * x[0] + 3 * t * Math.pow(1 - t, 2) * x[1] + 3 * t * t * (1 - t) * x[2]
                    + Math.pow(t, 3) * x[3]);
            ly[i] = (int)(Math.pow(1 - t, 3) * y[0] + 3 * t * Math.pow(1 - t, 2) * y[1] + 3 * t * t * (1 - t) * y[2]
                    + Math.pow(t, 3) * y[3]);
//            g.fillOval(lx[i], ly[i], 10, 20);

            //quadratic
            qlx[i] = (int)((1-t) * ((1-t)*x[0]+t*x[1]) ) + (int)(t * ((1-t)*x[1] + t*x[2]));
            qly[i] = (int)((1-t) * ((1-t)*y[0]+t*y[1]) ) + (int)(t * ((1-t)*y[1] + t*y[2]));
//            g.fillOval(qlx[i], qly[i], 10, 20);

            // linear
            llx[i] = (int)(x[0]+ t* (x[1]+ x[2]));
            lly[i] = (int)(y[0]+ t* (y[1]+ y[2]));
//            g.fillOval(llx[i], lly[i], 10, 20);

            i++;
        }


        for (t = 0.0; t <= 1.0; t += 0.001) {
            nx = (int)(Math.pow(1 - t, 3) * x[0] + 3 * t * Math.pow(1 - t, 2) * x[1] + 3 * t * t * (1 - t) * x[2]
                    + Math.pow(t, 3) * x[3]);
            ny = (int)(Math.pow(1 - t, 3) * y[0] + 3 * t * Math.pow(1 - t, 2) * y[1] + 3 * t * t * (1 - t) * y[2]
                    + Math.pow(t, 3) * y[3]);


            xy[0] = (int)((1 - t) * x[0] + t * x[1]);
            xy[1] = (int)((1 - t) * y[0] + t * y[1]);
            xy[2] = (int)((1 - t) * x[1] + t * x[2]);
            xy[3] = (int)((1 - t) * y[1] + t * y[2]);
            xy[4] = (int)((1 - t) * x[2] + t * x[3]);
            xy[5] = (int)((1 - t) * y[2] + t * y[3]);
            xy[6] = (int)((1 - t) * xy[0] + t * xy[2]);
            xy[7] = (int)((1 - t) * xy[1] + t * xy[3]);
            xy[8] = (int)((1 - t) * xy[2] + t * xy[4]);
            xy[9] = (int)((1 - t) * xy[3] + t * xy[5]);
            g.setColor(Color.GREEN);


//             Outline
            g.drawLine(x[0], y[0], x[1], y[1]);
            g.drawLine(x[1], y[1], x[2], y[2]);
            g.drawLine(x[2], y[2], x[3], y[3]);

            // control point
            g.fillOval(x[0] - 5, y[0] - 5, 10, 10);
            g.fillOval(x[1] - 5, y[1] - 5, 10, 10);
            g.fillOval(x[2] - 5, y[2] - 5, 10, 10);
            g.fillOval(x[3] - 5, y[3] - 5, 10, 10);
            g.setColor(Color.yellow);

//             Trace
            g.drawLine(nx - 5, ny, nx + 5, ny);
            g.drawLine(nx, ny - 5, nx, ny + 5);
//            actual curve...
            g.drawPolyline(lx, ly, i);
            g.drawPolyline(qlx, qly, i);
            g.drawPolyline(llx, lly, i);

            g.setColor(Color.white);
            g.drawLine(xy[0], xy[1], xy[2], xy[3]);
            g.drawLine(xy[2], xy[3], xy[4], xy[5]);
            g.drawLine(xy[6], xy[7], xy[8], xy[9]);

            // Label of Control points
            g.drawString("A", x[0] + 5, y[0] - 5);
            g.drawString("B", x[1] + 5, y[1] - 5);
            g.drawString("C", x[2] + 5, y[2] - 5);
            g.drawString("D", x[3] + 5, y[3] - 5);

            // Label ofe interal moving line
            g.drawString("AB", xy[0] + 5, xy[1] - 5);
            g.drawString("BC", xy[2] + 5, xy[3] - 5);
            g.drawString("CD", xy[4] + 5, xy[5] - 5);
            g.drawString("ABC", xy[6] + 5, xy[7] - 5);
            g.drawString("BCD", xy[8] + 5, xy[9] - 5);

            //  bold end of line
            g.fillOval(xy[0] - 4, xy[1] - 4, 8, 8);
            g.fillOval(xy[2] - 4, xy[3] - 4, 8, 8);
            g.fillOval(xy[4] - 4, xy[5] - 4, 8, 8);
            g.fillOval(xy[6] - 4, xy[7] - 4, 8, 8);
            g.fillOval(xy[8] - 4, xy[9] - 4, 8, 8);


            sleep();
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 1000, 1000);
        }
    }
    // Main Method
    // if This method raise any error Remove the Main method
    public static void main(String[] args)
    {
        Qs2 a = new Qs2();
        JFrame jp1 = new JFrame();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(1000, 1000));
        jp1.setVisible(true);
    }
}