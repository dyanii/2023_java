package num1;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CarGame extends JFrame{
	class MyThread extends Thread{
		private JLabel label;
		private int x, y;
		
		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;
			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x,y,100,100);
			add(label);
			
		}
		
		public void run() {
			for(int i=0; i<200; i++) {
				x+=10*Math.random();
				label.setBounds(x,y,100,100);
				repaint();
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void paint(Graphics g) {
			System.out.println("paint");
			g.drawLine(600, 0, 600, 550);
			
			/*
			for(int k=0;k<i.length;k++){
				   if(thread1.x == 750 && i[k]==0&&re1){i[k]=1;re1=false;break;}
				   else if(thread2.x == 750 && i[k]==0&&re2){i[k]=2;re2=false;break;}
				   else if(thread3.x == 750 && i[k]==0&&re3){i[k]=3;re3=false;break;}
				   else if(thread4.x == 750 && i[k]==0&&re4){i[k]=4;re4=false;break;}
				   else if(thread5.x == 750 && i[k]==0&&re5){i[k]=5;re5=false;break;}
				  }
				  if(i[0]>0)  g.drawString("1등"+i[0]+"번말 우승",260,350);   
				  if(i[1]>0) g.drawString("2등"+i[1]+"번말 준우승",260,350+20);
				  if(i[2]>0) g.drawString("3등"+i[2]+"번말 ",260,350+40);
				  if(i[3]>0) g.drawString("4등"+i[3]+"번말 ",260,350+60);
				  if(i[4]>0) g.drawString("5등"+i[4]+"번말 ",260,350+80);
			*/
		}
	}
	
	public CarGame() {
		setTitle("CarRace");
		setSize(700, 400);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		(new MyThread("car1.gif", 100, 0)).start();
		(new MyThread("car2.gif", 100, 50)).start();
		(new MyThread("car3.gif", 100, 100)).start();
		(new MyThread("car4.gif", 100, 150)).start();
		(new MyThread("car5.gif", 100, 200)).start();
		
		//x축이 600일때 1등입니다 출력할 수 있게
			System.out.println("car이 우승했습니다!");
		//배경색깔 바꾸는 것도 함 해보기
		//이런게 기말준비겠죠?
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CarGame t = new CarGame();
	}
}