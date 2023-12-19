package num2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bubble extends JFrame{
	public Bubble() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500, 500);
		setVisible(true);
		
		Thread t;
		
		JButton btn = new JButton("시작");
		btn.setBounds(150,400,70,23);
		
		btn.addActionListener(e-> gamestart());
		
		JButton btn2 = new JButton("종료");
		btn2.setBounds(230,400,70,23);
		
		btn2.addActionListener(e-> gamestop());

		add(btn);
		add(btn2);
		setVisible(true);
	}

	private JLabel bubble;
	public void BubbleThread(int bubbleX, int bubbleY) {
		ImageIcon img = new ImageIcon("bubble.jpg");
		bubble = new JLabel(img);
		bubble.setSize(img.getIconWidth(), img.getIconHeight());
		bubble.setLocation(bubbleX, bubbleY);
		add(bubble);
		repaint();
	}
	
	private void gamestart() {
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
				Thread.sleep(200);
				
			}
			catch(InterruptedException e) {}
		}
	}

	private void gamestop() {
		{ }
	}
	
	public static void main(String[] args) {
		new Bubble();
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