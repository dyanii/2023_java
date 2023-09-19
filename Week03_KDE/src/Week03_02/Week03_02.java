package Week03_02;

import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame
{
	JButton button;
	JTextField t1;
	JTextField t2;
	public MyFrame() {
		setTitle("마일을 킬로미터로 변환");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 =new JPanel();
		JLabel label = new JLabel("거리를 마일 단위로 입력하시오");
		t1 = new JTextField(7);
		t2 = new JTextField(25);
		button = new JButton("변환");
		button.addActionListener(new MyListener());
		t1.setText("1");
		
		t2.setEditable(false);
		panel1.add(label);
		panel1.add(t1);
		panel1.add(button);
		panel1.add(t2);
		this.add(panel1);
		
		setVisible(true);
	}
	
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==button)
			{
				int t = Integer.parseInt(t1.getText());
				double k = t*1.609344;
				t2.setText(t + "마일은 " +k+ "킬로미터입니다.");
			}
		}
	}
}

public class Week03_02 {
	public static void main(String[] args) {
		MyFrame hi = new MyFrame();
	}

}
