package num4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class StudentViewer extends JFrame {
	JTextField stuId, name, tel, dept, search;
	JButton previousButton, nextButton, insertButton, deleteButton,
			searchButton, clearButton;
	ResultSet rs;
	Statement stmt;
	
	public StudentViewer() throws SQLException {
		super("Student Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet이 처음부터 끝까지 이동하면서 데이터를 순회할 수 있음
		rs = stmt.executeQuery("SELECT * FROM student");
		//모든 데이터를 가져옴
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("stuID", JLabel.CENTER));
		add(stuId = new JTextField());
		
		add(new JLabel("name", JLabel.CENTER));
		add(name = new JTextField());
		
		add(new JLabel("tel", JLabel.CENTER));
		add(tel = new JTextField());
		
		add(new JLabel("dept", JLabel.CENTER));
		add(dept = new JTextField());
		
		add(new JLabel("이름 검색", JLabel.CENTER));
		add(search = new JTextField());

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous(); //ResultSet에서 가져온 데이터를 화면에 업데이트
					stuId.setText("" + rs.getString("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					stuId.setText("" + rs.getString("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    // 사용자가 입력한 데이터를 가져와서 데이터베이스에 추가하는 쿼리 실행
                    String insertQuery = "INSERT INTO student (stuId, name, tel, dept) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
                    preparedStatement.setString(1, stuId.getText());
                    preparedStatement.setString(2, name.getText());
                    preparedStatement.setString(3, tel.getText());
                    preparedStatement.setString(4, dept.getText());
                    preparedStatement.executeUpdate();

                    // 새로 추가된 레코드를 화면에 업데이트
                    rs = stmt.executeQuery("SELECT * FROM student");
                    rs.last();
                    updateTextFieldsWithCurrentRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    // 현재 표시된 레코드를 삭제하는 쿼리 실행
                    rs.deleteRow();

                    // 다음 레코드로 이동하여 화면에 업데이트
                    if (rs.next()) {
                        updateTextFieldsWithCurrentRow();
                    } else {
                        // 삭제 후 레코드가 없는 경우, 텍스트 필드를 비움
                        clearTextFields();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        String searchKeyword = search.getText(); // 여기서는 search가 아닌 searchPublisher를 사용해야 함
		        try {
		            // SQL 쿼리를 사용하여 저자 이름을 기준으로 검색
		            String query = "SELECT * FROM student WHERE name LIKE '%" + searchKeyword + "%'";
		            ResultSet searchResult = stmt.executeQuery(query);
		            
		            // 검색 결과가 있으면 ResultSet에서 가져온 데이터를 화면에 업데이트
		            if (searchResult.next()) {
		                stuId.setText("" + searchResult.getString("stuId"));
		                name.setText("" + searchResult.getString("name"));
		                tel.setText("" + searchResult.getString("tel"));
		                dept.setText("" + searchResult.getString("dept"));
		            } else {
		                System.out.println("검색 결과가 없습니다.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // 텍스트 필드를 비움
                clearTextFields();
            }
        });
		
		add(previousButton);
		add(nextButton);
		add(insertButton);
		add(deleteButton);
		add(searchButton);
		add(clearButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
	
	private void updateTextFieldsWithCurrentRow() throws SQLException {
        stuId.setText("" + rs.getString("stuId"));
        name.setText("" + rs.getString("name"));
        tel.setText("" + rs.getString("tel"));
        dept.setText("" + rs.getString("dept"));
    }
	
	private void clearTextFields() {
        stuId.setText("");
        name.setText("");
        tel.setText("");
        dept.setText("");
        search.setText("");
    }
	
	public static Connection makeConnection() {	
		String url = "jdbc:mysql://localhost:3306/Duksung";
		String id = "root";
		String password = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		new StudentViewer();
	}
}
