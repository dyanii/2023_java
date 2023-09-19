package Week03_03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame implements ActionListener, KeyListener{
	JPanel p1, p2, p3;
	JButton b1, b2;
	int x=200;
	
	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		setTitle("자동차 움직이기");
		
		p1 = new JPanel();
		p3 = new JPanel();
		p1.setLayout(new BorderLayout());
		b1 = new JButton("LEFT");
		b1.addActionListener(this);
		b1.setFocusable(false);
		b2 = new JButton("RIGHT");
		b2.addActionListener(this);
		b2.setFocusable(false);
		p2 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.yellow);
				g.fillRect(0, 0, 500, 400);
				g.setColor(Color.RED);
				g.fillRect(x, 40, 50, 200);
			}
		};
		
		this.addKeyListener(this);
		p3.add(b1);
		p3.add(b2);
		
		p1.add(p2, BorderLayout.CENTER);
		p1.add(p3, BorderLayout.SOUTH);
		
		add(p1);
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x-=20;
			if(x<20)
				x=450;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x+=20;
			if(x>450)
				x=10;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			x-=20;
			if(x<20)
				x=450;
		}
		if(e.getSource()==b2)
		{
			x+=20;
			if(x>450)
				x=10;
		}
		repaint();
	}
	
}

public class Week03_03 {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}
