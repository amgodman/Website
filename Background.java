   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
    public class Background extends JPanel
   {
      private static final int N = 800;
      private static Color background = new Color(0, 0, 255);
      private static Color inverse = new Color(255, 255, 0);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball, ball2;
      private Timer t;
		private int hits=0; 
		//constructor   
       public Background()
      {
         myImage =  new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(background);
         myBuffer.fillRect(0, 0, N,N);
         int xPos = (int)(Math.random()*(N-100) + 50);
         int yPos = (int)(Math.random()*(N-100)+ 50);
         int xPos2 = (int)(Math.random()*(N-100) + 50);
         int yPos2 = (int)(Math.random()*(N-100)+ 50);
         ball = new Ball(xPos, yPos, 50, background);
         ball2 = new Ball(N-xPos, N-yPos, 50, inverse);
        
         t = new Timer(5, new Listener());
         t.start();
			addMouseMotionListener(new MouseM());
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
		private class MouseM extends MouseMotionAdapter
		{
			public void mouseMoved(MouseEvent e)
			{
            background = new Color(255*e.getX()/850, 255*e.getY()/850, 255);
            inverse = new Color(255-background.getRed(), 255-background.getGreen(), 255-background.getBlue());
			}
		}
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(background);    //cover the 
            myBuffer.fillRect(0,0,N,N);   //old ball
            ball.draw(myBuffer, N, N, background); 
            ball2.draw(myBuffer, N, N, inverse);
            repaint();
         }
      }   
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
      }
   }
