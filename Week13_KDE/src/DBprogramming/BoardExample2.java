package DBprogramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BoardExample2 {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/boards";
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
	
	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴선택: ");
		System.out.println();
	}
	
	
	
	
	
	public void create() {
		System.out.println("*** create 메소드 실행됨");
		list();
	}
	
	public void read() {
		System.out.println("*** read 메소드 실행됨");
		list();
	}
	
	public void clear() {
		System.out.println("*** clear 메소드 실행됨");
		list();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		BoardExample2 boardExample = new BoardExample2();
		boardExample.list();
	}
}
