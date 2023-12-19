package num3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/* USE Duksung;

CREATE TABLE Student (
stuId VARCHAR(10) PRIMARY KEY,
name VARCHAR(40),
tel VARCHAR(20),
dept VARCHAR(30)
);
 */

public class StudentTable {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/Duksung";
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
	
	public static void main(String arg[]) throws SQLException{
		System.out.println("stuId	name	tel		dept");
		
		addstudent("2022001", "Kim", "000-0000-0001", "CS");
		addstudent("2022002", "Lee", "000-0000-0002", "Com");
		addstudent("2022003", "Park", "000-0000-0003", "IT");
		addstudent("2022004", "Choi", "000-0000-0004", "SW");
	}
	
	private static void addstudent
	(String stuId, String name, String tel, String dept) {
		Connection con = makeConnection();
		
		try {
			Statement stmt = con.createStatement();
			String s = "INSERT INTO student(stuId, name, tel, dept) VALUES ";
			s += "('" + stuId + "','" + name + "','" + tel + "','" + dept + "')";
			
			System.out.println(stuId +"  "+ name + "  " + tel + "     " + dept);
			int i = stmt.executeUpdate(s);
			if(i == 1)
				System.out.println("");
			else
				System.out.println("레코드 추가 실패)");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}