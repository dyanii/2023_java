package Week04_01;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Person{
	String name;
	String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	String address;
	public Person(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
}

public class Week04_01 extends JFrame {
	ArrayList<Person> list = new ArrayList<>();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_l;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Week04_01 frame = new Week04_01();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Week04_01() {
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(12,10,57,15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_l = new JLabel("전화번호");
		lblNewLabel_l.setBounds(12, 42, 57, 15);
		contentPane.add(lblNewLabel_l);
		
		textField = new JTextField();
		textField.setBounds(81, 7, 243, 21);
		contentPane.add(textField);
		
		textField_l = new JTextField();
		textField_l.setColumns(10);
		textField_l.setBounds(81, 39, 243, 21);
		contentPane.add(textField_l);
		
		JLabel lblNewLabel_2 = new JLabel("주소");
		lblNewLabel_2.setBounds(12, 79, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 104, 312, 67);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("저장");
		btnNewButton.setBounds(12, 181, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(e->{
			String name = textField.getText();
			String tel = textField_l.getText();
			String address = textArea.getText();
			list.add(new Person(name, tel, address));
		});
		
		JButton btnNewButton_l = new JButton("검색");
		btnNewButton_l.setBounds(117, 181, 97, 23);
		contentPane.add(btnNewButton_l);
		btnNewButton_l.addActionListener(e->{
			String name = textField.getText();
			for(Person p : list) {
				if(p.getName().equals(name)) {
					textField_l.setText(p.getTel());
					textArea.setText(p.getAddress());
				}
			}
		});
		
		JButton btnNewButton_l_l = new JButton("종료");
		btnNewButton_l_l.setBounds(227, 181, 97, 23);
		contentPane.add(btnNewButton_l_l);
		btnNewButton_l_l.addActionListener(e->{
			System.exit(0);
		});
	}

}
