   import javax.swing.*;
   import javax.swing.event.*;
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
      private Timer t, resumet;
		private int hits=0;
      private JSlider slider;
      private BorderLayout manager = new BorderLayout();
      private JLabel bar;
      private JMenuBar menu = new JMenuBar();
      private JMenu home, aboutMe, resume, games;
      private JMenuItem h, r;
      private JPanel menup = new JPanel();
       private JPanel bpanel = new JPanel();
      private static boolean res;
      private static int ry=50;
      private static int rx = 60;
      private JCheckBox lock, wte;
      private boolean locked = false;
      private boolean white = false;
		//constructor   
       public Background()
      {
         myImage =  new BufferedImage(N, N, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(background);
         myBuffer.fillRect(0, 0, N,N);
         setLayout(manager);
         setFocusable(true);
/*         ballp = new BallPanel();
         add(ballp, manager.CENTER);*/
         menup.setLayout(new BorderLayout());
         menup.setSize(800,50);
         menu.setLayout(new BoxLayout(menu, BoxLayout.X_AXIS));
         menu.setBackground(Color.orange.darker());
         bar = new JLabel("Visibility", SwingConstants.LEFT);
         bar.setForeground(Color.orange.darker());
         menup.add(bar, BorderLayout.WEST);
         home = new JMenu("Home");
         h = new JMenuItem("Home");
         home.add(h);
         menu.add(home);
         aboutMe= new JMenu("About Me");
         menu.add(aboutMe);
         menu.setBorderPainted(true);
         resume = new JMenu("Resume");
         r = new JMenuItem("Resume");
         r.setBackground(Color.blue.darker());
         r.setForeground(Color.orange.darker());
         r.addActionListener(new ResumeListener());
         resume.add(r);
         menu.add(resume);
         games = new JMenu("Games");
         menu.add(games);
         menup.setBackground(Color.blue.darker());
         menup.add(menu);
         add(menup,manager.NORTH);
         int xPos = (int)(Math.random()*(N-100) + 50);
         int yPos = (int)(Math.random()*(N-100)+ 50);
         int xPos2 = (int)(Math.random()*(N-100) + 50);
         int yPos2 = (int)(Math.random()*(N-100)+ 50);
         ball = new Ball(xPos, yPos, 50, background);
         ball2 = new Ball(N-xPos, N-yPos, 50, inverse);
         slider = new JSlider(SwingConstants.VERTICAL, 0, 255, 255);
         slider.addChangeListener(new BarListener());
         slider.setPaintTicks(true);
         slider.setMajorTickSpacing(5);
         slider.setMinorTickSpacing(1);
         slider.setPaintLabels(true);
         slider.setPaintTrack(false);
         add(slider, manager.WEST);
         bpanel.setLayout(new GridLayout(1,2));
         lock = new JCheckBox("Lock Background");
         lock.addActionListener(new LockListener());
         bpanel.add(lock);
         wte = new JCheckBox("White Background");
         wte.setEnabled(false);
         wte.addActionListener(new WhiteListener());
         bpanel.add(wte);
         add(bpanel, manager.SOUTH);
         t = new Timer(5, new Listener());
         t.start();
			addMouseMotionListener(new MouseM());
      }
      private void draws(String s, int x, int dy)
      {
         ry+=dy;
         myBuffer.drawString(s, x, ry);
      }
      private void drawResume()
      {
         ry=50;
         Font title = new Font("Times New Roman", Font.BOLD, 32);
         Font sheader = new Font("Times New Roman", Font.BOLD, 20);
         int dsh=22;
         Font header = new Font("Times New Roman", Font.BOLD, 14);
         int dh=16;
         Font body = new Font("Times New Roman", Font.PLAIN, 14);
         int db=16;
         int spacer = 15;
         myBuffer.setColor(Color.black);
         myBuffer.setFont(title);
         draws("Austin Godman", 300, 0);
         myBuffer.setFont(header);
         draws("Permanent Address: 21260 Rosetta Pl., Ashburn, VA 20147", 228, dh);
         draws("Campus Address: 206 E. Peabody Dr. #396, Champaign, IL 61820", 210, dh);
         draws("Phone: (571)232-6650 | Email: Austin.Godman@gmail.com", 230, dh);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Education", rx, dsh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(header);
         draws("University of Illinois at Urbana Champaign", rx, dh);
         myBuffer.setFont(body);
         draws("Urbana,IL", 700, 0);
         draws("B.S. Computer Science, College of Engineering", rx, dh);
         draws("May 2017", 700, 0);
         draws("GPA: 3.70", 700, dh);
         ry+=spacer;
         myBuffer.setFont(header);
         draws("Broad Run High School", rx, dh);
         myBuffer.setFont(body);
         draws("Ashburn, VA", 700, 0);
         draws("Graduated June, 2013", rx, dh);
         draws("GPA: 4.16", 700, 0);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Work Experience", rx, dh);
         myBuffer.drawLine(0, ry+1, 800, ry+1);
         myBuffer.setFont(header);
         draws("UPS Store", rx, dh);
         myBuffer.setFont(body);
         draws("Ashburn, VA", 700, 0);
         draws("Sales Associate", rx, dh);
         draws("2011-2013", 700, 0);
         draws(" - Managed retail", 95, dh);
         draws(" - Assisted customers", 95, dh);
         ry+=spacer;
         myBuffer.setFont(header);
         draws("Riverside Church", rx, dh);
         myBuffer.setFont(body);
         draws("Sterling, VA", 700, 0);
         draws("Sound Technician", rx, dh);
         draws("2004-2013", 700, 0);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Skills", rx, dh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(body);
         draws("Spoken Languages: English, Spanish", rx, dh);
         draws("Programming Languages and Applications: Java, Wolfram Mathematica", rx, dh);
         draws("OSHA certifications in Mechanical Safety and Mechanical Pollution Prevention", rx, dh);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Leadership Experience", rx, dh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(header);
         draws("Independent Science Research - Moonbuggy", rx, dh);
         myBuffer.setFont(body);
         draws("Fall 2012 - Spring 2013", 650, 0);
         draws("Chassis Team Leader", rx, dh);
         draws("- Delegated responsibilities to team members", rx, dh);
         draws("- Managed team budget and deadlines", rx, dh);
         draws("- Team Website: www.brhsmoonbuggy.com", rx, dh);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Extracirricular Activities", rx, dh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(body);
         draws("Cross Country", rx, dh);
         draws("- 250 Mile Club Charter Member", 95, dh);
         draws("Track & Field", rx, dh);
         draws("Riverside Presbyterian Church", rx, dh);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Achievements", rx, dh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(body);
         draws("Teacher's Choice CS student", rx, dh);
         ry+=spacer;
         myBuffer.setFont(sheader);
         draws("Hobbies and Interests", 300, dh);
         myBuffer.drawLine(0, ry+2, 800, ry+2);
         myBuffer.setFont(body);
         draws("Java Game Coding | Hands on Woodworking | Solving Puzzles | Spending Time with Friends", 135, dh);
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
		private class MouseM extends MouseMotionAdapter
		{
			public void mouseMoved(MouseEvent e)
			{
            if(!locked)
            {
               background = new Color(255*e.getX()/850, 255*e.getY()/850, 255);
               inverse = new Color(255-background.getRed(), 255-background.getGreen(), 255-background.getBlue());
            }
			}
		}
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(background);    //cover the
            if(white)   myBuffer.setColor(Color.white);
            myBuffer.fillRect(0,0,N,N);   //old ball
            if(!white)
            {
               ball.draw(myBuffer, N, N, background, !locked); 
               ball2.draw(myBuffer, N, N, inverse, !locked);
            }
            for(int i=0; i<800; i+=10)
            {
               myBuffer.setColor(Color.black);
               if(i%100==0)   myBuffer.setColor(Color.red);
               myBuffer.fillOval(i-2, 20, 4, 4);
            }
            if(res)
            {
               drawResume();
            }
            bpanel.setBackground(background);
            repaint();
         }
      }   
      private class BarListener implements ChangeListener
      {
         public void stateChanged(ChangeEvent e)
         {
            JSlider temp = (JSlider)e.getSource();
            ball.setAlpha(temp.getValue());
            ball2.setAlpha(temp.getValue());
         }
      }
      private class ResumeListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            Background.res=true;
         }
      }
      private class LockListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            locked=lock.isSelected();
            wte.setEnabled(locked);
         }
      }
      private class WhiteListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            white=wte.isSelected();
            lock.setEnabled(!white);
         }
      }
       private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
      }
   }
