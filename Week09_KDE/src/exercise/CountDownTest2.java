package exercise;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest2 extends JFrame{
	private JLabel label;
	
	Thread t;
	
	class Counter extends Thread{
		public void run() {
			for(int i=0; i<=10; i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					return;
				}
				label.setText(i  + "");
			}
		}
	}
	
	public CountDownTest2() {
		setTitle("카운트다운2");
		setSize(400, 150);
		getContentPane().setLayout(null);
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111);
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label);
		
		JButton btn = new JButton("카운터 중지");
		btn.setBounds(247, 25, 125, 23);
		
		btn.addActionListener(e-> t.interrupt());
		getContentPane().add(btn);
		setVisible(true);
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		CountDownTest2 t2 = new CountDownTest2();
	}
}