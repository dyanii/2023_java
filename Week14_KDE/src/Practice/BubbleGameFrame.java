package Practice;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGameFrame extends JFrame{
	public BubbleGameFrame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleGameFrame();
	}
}

class GamePanel extends JPanel{
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new BubbleThread(e.getX(), e.getY()).start();
			}
		});
	}
	
	class BubbleThread extends Thread{
		private JLabel bubble;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(), img.getIconHeight());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);
			repaint();
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5;
				if(y < 0) {
					remove(bubble);
					repaint();
					return;
					
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
