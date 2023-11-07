package Week09_01;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame{
	private JLabel label;
	
	Thread t;
	
	class Counter extends Thread{
		public void run() {
			for(int i=0; i<=100; i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					return;
				}
				label.setText(i + "");
			}
		}
	}
	
	public CountDownTest() {
		setTitle("카운트다운");
		setSize(400, 150);
		getContentPane().setLayout(null);
		
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111);
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label);
		
		JButton btn1 = new JButton("카운트 중지");
		btn1.setBounds(247, 25, 130, 23);
		btn1.addActionListener(e->t.interrupt());
		getContentPane().add(btn1);
		
		JButton btn2 = new JButton("카운트 다시 시작");
		btn2.setBounds(247, 50, 130, 23);
		btn2.addActionListener(e->{
			t = new Counter();
			t.start();
		});
		getContentPane().add(btn2);
		
		setVisible(true);
		t = new Counter();
		t.start();
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}
}
