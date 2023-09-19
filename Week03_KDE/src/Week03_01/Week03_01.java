package Week03_01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{
	JButton SUBMIT, CANCEL;
	JPanel panel;
	JLabel label1, label2, label3, label4;
	final JTextField text1, text2, text3, text4;
	
	public MyFrame() {
		setTitle("회원 등록하기");
		setSize(300,300);
		label1 = new JLabel();
		label1.setText("이름");
		text1 = new JTextField(30);
		
		label2 = new JLabel();
		label2.setText("패스워드");
		text2 = new JPasswordField(30);
		
		label3 = new JLabel();
		label3.setText("이메일 주소");
		text3 = new JTextField(30);
		
		label4 = new JLabel();
		label4.setText("전화번호");
		text4 = new JTextField(30);
		
		SUBMIT = new JButton("등록하기");
		CANCEL = new JButton("취소");
		
		panel = new JPanel(new GridLayout(0,1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(label4);
		panel.add(text4);
		panel.add(SUBMIT);
		panel.add(CANCEL);
		add(panel, BorderLayout.CENTER);
		SUBMIT.addActionListener(this);
		setTitle("회원 등록하기");
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String value1 = text1.getText();
		String value2 = text2.getText();
		String value3 = text3.getText();
		String value4 = text4.getText();
		
		if(value1.equals("kim")&&value2.equals("1111")) {
			System.out.println("등록 성공!");
		}else {
			System.out.println("다시 시도하세요~");
		}
	}
}

public class Week03_01 {
	public static void main(String[] args) {
		new MyFrame();
	}
}
