package Run;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import javax.swing.JPanel;

public class Surface extends JPanel {
	// toa do
	int R2;
        int R1;
        int x1 = 375;//tam O tuong ung voi he toa do cua chuong trinh
        int y1 = 375;
	int index;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.setBackground(Color.YELLOW);
		this.setBounds(300, 0, 750, 750);
		Graphics2D g2d = (Graphics2D) g;
		Axis(g2d);
                g.setColor(Color.red);
               g.fillOval(370, 370, 10, 10);
		doDrawing(g2d);
	}

	// ham ve thi ta ve vao day
	public Surface() {
		this.index = -1;
	}

	public void doDrawing(Graphics2D g2d) {
		// ham chuc nang
		Axis(g2d);
		if (index == 0) {
			//drawCircle(g2d, R2);
                        DrawElip(g2d,x1,y1,R1,R2);
		}
	}

	// ham ve toa do
	public void Axis(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 150; i++) {
			g2d.drawLine(5 * i, 0, 5 * i, 750);// moi don vi la 15pixel
			g2d.drawLine(0, 5 * i, 750, 5 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, 375, 750, 375);// truc ngang
		g2d.drawLine(375, 0, 375, 750);// truc doc
	}

        
        
        public void DrawElip(Graphics2D g2d,int x_center,int y_center,int a,int b){
                  float p,a2,b2;
                  int x,y;
                  int check1=1;
                  int check2=1;
                  a2=a*a;
                  b2=b*b;
                  x=0;
                  y=b;
                  p=2*((float)b2/a2)-(2*b)+1;
                  
                  //Ve net dut
                  //ve nhanh thu 1(tren trai)
                  while(((float)b2/a2)*x<=y)
                  {
                      if(check1 %2 != 0){
                          for(int i=0;i<5;i++){
                                putnetdut(g2d,x_center,y_center,x,y);
                            if(p<0)
                            {
                                p=p+2*((float)b2/a2)*(2*x+3);
                            }
                            else{
                                p= p- 4*y + 2*((float)b2/a2)*(2*x+3);
                                y--;
                            }
                            x++;  
                           }                                               
                      }else{
                       for(int i=0;i<5;i++){
                             if(p<0)
                             {
                                 p=p+2*((float)b2/a2)*(2*x+3);
                             }
                             else{
                                 p= p- 4*y + 2*((float)b2/a2)*(2*x+3);
                                 y--;
                             }
                             x++;                      
                       }                        
                     }
                      check1 ++;
                  }
                     
                  //ve nhanh thu 2(phia tren ben phai)
                  y=0;
                  x=a;
                  p=2*((float)a2/b2)-2*a+1;
                  while(((float)a2/b2)*y<=x)
                  {
                      if(check2 %2 !=0){
                        for(int i=0;i<5;i++){
                             putnetdut(g2d,x_center,y_center,x,y);
                          if(p<0)
                         {
                           p=p +2*((float)a2/b2)*(2*y+3);
                         }else
                         {
                          p=p- 4*x + 2*((float)a2/b2)*(2*y+3);
                          x--;
                         }
                          y++;
                        } 
                      }else{
                        for(int i=0;i<5;i++){
                            if(p<0)
                         {
                           p=p +2*((float)a2/b2)*(2*y+3);
                         }else
                         {
                          p=p- 4*x + 2*((float)a2/b2)*(2*y+3);
                          x--;
                         }
                          y++;
                      
                       } 
                      }
                     check2++;
                  }    
                  
                  // ve net lien
                   x=0;
                   y=b;
                   p=2*((float)b2/a2)-(2*b)+1;
                  //ve nhanh thu 3(phia duoi ben phai)
                    while(((float)b2/a2)*x<=y)
                    {
                        putnetlien(g2d,x_center,y_center,x,y);
                        if(p<0)
                        {
                            p=p+2*((float)b2/a2)*(2*x+3);
                        }
                        else{
                            p= p- 4*y + 2*((float)b2/a2)*(2*x+3);
                            y--;
                        }
                        x++;
                    }
                              
                  //ve nhanh thu 4(phia duoi ben trai)
                    y=0;
                    x=a;
                    p=2*((float)a2/b2)-2*a+1;
                    while(((float)a2/b2)*y<=x)
                    {
                        putnetlien(g2d,x_center,y_center,x,y);
                        if(p<0)
                        {
                            p=p +2*((float)a2/b2)*(2*y+3);
                        }
                        else
                        {
                            p=p- 4*x + 2*((float)a2/b2)*(2*y+3);
                            x--;
                        }
                        y++;
                    } 
      }
          
          void putnetdut(Graphics g2d,int xc,int yc,int x,int y){
             g2d.setColor(Color.red);  
             g2d.fillOval(xc-x, yc-y,5,5);//trên trái
             g2d.fillOval(xc+x, yc-y,5,5);//trên phải
            
       }
          void putnetlien(Graphics g2d,int xc,int yc,int x,int y){
             g2d.setColor(Color.red);  
             g2d.fillOval(xc+x, yc+y,5,5); //dưới phải
             g2d.fillOval(xc-x, yc+y,5,5); //dưới trái
            
       }
}
