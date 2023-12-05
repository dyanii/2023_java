package DBprogramming;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

public class BoardSelectExample02 {
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
	
	public static void main(String arg[]) {
		Connection con = makeConnection();
		
		try {
			String sql = "" + 
						"SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " + 
						"FROM boards " + 
						"WHERE bwriter=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				
				System.out.println(board);
				
				Blob blob = board.getBfiledata();
				if(blob != null) {
					try (InputStream is = blob.getBinaryStream();
							OutputStream os = new FileOutputStream("C:/Temp/" + board.getBfilename())){
						
							is.transferTo(os);
							os.flush();
					}catch (IOException e) {
					e.printStackTrace();		
				}
			}
		}
		rs.close();
		
		pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch (SQLException e) {}
			}
		}
	}
}
