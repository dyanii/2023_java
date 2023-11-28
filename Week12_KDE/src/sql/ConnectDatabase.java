package sql; //이거랑 비슷한 유형의 문제를 기말로 낼것임

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	JTextField id, title, publisher, year, price, search;
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;
	
	public MyFrame() throws SQLException{
		super("Database Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery("SELECT * FROM books");
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(id = new JTextField());
		
		add(new JLabel("TITLE", JLabel.CENTER));
		add(title = new JTextField());
		
		add(new JLabel("PUBLISHER", JLabel.CENTER));
		add(publisher = new JTextField());
		
		add(new JLabel("YEAR", JLabel.CENTER));
		add(year = new JTextField());
		
		add(new JLabel("PRICE", JLabel.CENTER));
		add(price = new JTextField());
		
		add(new JLabel("출판사 검색", JLabel.CENTER));
		add(search = new JTextField());
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("title"));
					publisher.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("year"));
					price.setText("" + rs.getInt("price"));
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
					
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("title"));
					publisher.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("year"));
					price.setText("" + rs.getInt("price"));
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		InsertButton = new JButton("Insert");
		deleteButton = new JButton("Delete");
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String searchKeyword = search.getText();
				try {
					String query = "SELECT * FROM books WHERE publisher LIKE '%"
							+ searchKeyword + "%'";
					ResultSet searchResult = stmt.executeQuery(query);
					
					if(searchResult.next()) {
						id.setText("" + searchResult.getInt("book_id"));
						title.setText("" + searchResult.getString("title"));
						publisher.setText("" + searchResult.getString("publisher"));
						year.setText("" + searchResult.getString("year"));
						price.setText("" + searchResult.getInt("price"));
					}else {
						System.out.println("검색 결과가 없습니다. ");
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		ClearButton = new JButton("Clear");
		
		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);
		add(ClearButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
	
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/book_db";
		String id = "root";
		String password = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e) {
			System.out.println("연결에 실패했습니다.");
		}
		return con;
	}
}

public class ConnectDatabase {
	public static void main(String[] args) throws SQLException{
		new MyFrame();
	}
}
