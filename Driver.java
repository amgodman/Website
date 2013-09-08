   import javax.swing.JFrame;
    public class Driver
   {
       public static void main(String[] args)
      { 
         JFrame frame = new JFrame("Unit2, Lab17");
         frame.setSize(816, 876);    //makes the mouse location correct
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Background p = new Background();
         frame.setContentPane(p);
         p.requestFocus();
         frame.setVisible(true);
         
      }
   }
