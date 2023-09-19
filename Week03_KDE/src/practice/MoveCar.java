/*
package practice;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveCar extends JFrame {
	int img_x=150, img_y=150;
	JButton button;
	JButton b1, b2;
	
	public MoveCar() {
		setSize(500,300);
		button = new JButton("");
		ImageIcon icon = new ImageIcon("C:/Users/kdaeu/OneDrive/바탕 화면/자동차.jpg");
		button.setIcon(icon);
		
		b1 = new JButton("LEFT");
		b2 = new JButton("RIGHT");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		button.setLocation(img_x, img_y);
		button.setSize(200,100);
		panel.add(b1);
		panel.add(b2);
		
		add(panel, BorderLayout.CENTER);
		b1.addActionListener(new MyListener());
		b2.addActionListener(new MyListener());
		panel.add(button);
		panel.requestFocus();
		
		panel.setFocusable(true);
		
		panel.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_LEFT: img_x-=20; break;
				case KeyEvent.VK_RIGHT: img_x+=20; break;
				}
				button.setLocation(img_x, img_y);
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MoveCar f = new MoveCar();
	}

}
*/
