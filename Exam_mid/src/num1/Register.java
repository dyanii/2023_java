package num1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Student extends JFrame implements ActionListener{
	JButton SUBMIT, CANCEL;
	JPanel panel;
	JLabel reg;
	JLabel name, num, grade;
	JTextField text1, text2, text3;
	
	public Student() {
		setTitle("덕성여대 화이팅");
		setSize(400, 300);
		
		reg = new JLabel("학생 등록하기");
		
		name = new JLabel();
		name.setText("이름");
		text1 = new JTextField(30);
		
		num = new JLabel();
		num.setText("학번");
		text2 = new JTextField(30);
		
		grade = new JLabel();
		grade.setText("성적");
		text3 = new JTextField(20);
		
		SUBMIT = new JButton("등록하기");
		CANCEL = new JButton("취소");
		
		panel = new JPanel(new GridLayout(0,1));
		panel.add(reg);
		panel.add(name);
		panel.add(text1);
		panel.add(num);
		panel.add(text2);
		panel.add(grade);
		panel.add(text3);
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
		
		System.out.println(" 이름: "+value1+" 학번: "+value2+" 성적: "+value3);
	}
}

public class Register{
	public static void main(String[] args) {
		new Student();
	}
}
