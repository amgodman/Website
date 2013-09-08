import java.awt.*;
public class Ball
{
   private int r=0;
   private double x,y,dx,dy=0.0;
   private double red,green,blue;
   private Color col, target;
   public Ball()
   {
      x=20;
      y=20;
      r=10;
      dx=6*Math.random()-3;
      dy=6*Math.random()-3;
      col= Color.blue;
      red=col.getRed();
      green=col.getGreen();
      blue=col.getBlue();
   }
   public Ball(double x, double y, int r, Color c)
   {
      this.x=x;
      this.y=y;
      this.r=r;
      dx=6*Math.random()-3;
      dy=6*Math.random()-3;
      col=c;
   }
   public double getX()
   {
      return x;
   }
   public double getY()
   {
      return y;
   }
   public double getdx()
   {
      return dx;
   }
   public double getdy()
   {
      return dy;
   }
   private void move(int mx, int my, Color target)
   {
      x+=dx;
      y+=dy;
      if(x >= mx - r)     //hits the right edge
      {
         x=mx - r;
         dx = dx * -1; 
      }
      else if(x<r)
		{
			x=r;
			dx*=-1;
		}
      if(y>=my-r)
		{
			y=my-r;
			dy*=-1;
		}
		else if(y<r)
		{
			y=r;
			dy*=-1;
		}
      int tr=target.getRed();
      int tg=target.getGreen();
      int tb=target.getBlue();
      double dr=tr-red;
      double dg=tg-green;
      double db=tb-blue;
      red+=dr/100;
      green+=dg/100;
      blue+=db/100;
      col=new Color((int)(red),(int)(green),(int)(blue));
  }
   public void draw(Graphics myBuffer, int mx, int my, Color target)
   {
      myBuffer.setColor(col);
      myBuffer.fillOval((int)x-r/2,(int)y-r/2,r,r);
      move(mx, my, target);
   }
}
