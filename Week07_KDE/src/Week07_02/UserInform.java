package Week07_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInform {
	public static void main(String[] args) throws IOException{
		int num2;
		String search;
		String num, name, tel, email;
		Scanner scan = null;
		PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
		Scanner s = new Scanner(System.in);
		Map<String, String> userMap = new HashMap<>();
		
		while(true) {
			System.out.println("번호: ");
			num = s.next();
			System.out.println("이름: ");
			name = s.next();
			System.out.println("전화번호: ");
			tel = s.next();
			System.out.println("이메일: ");
			email = s.next();
			System.out.println("입력을 끝냈으면 1, 계속하려면 0: ");
			num2 = s.nextInt();
			in.print(num + ", " + name + ", " + tel + ", " + email + "");
			in.flush();
			if(num2 == 1)
				break;
		}
		
		in.close();
		
		System.out.println("검색하실 사용자 번호를 입력하세요: ");
		num2 = s.nextInt();
		search = num2 + "";
		scan = new Scanner(new BufferedReader(new FileReader("user.txt")));
		scan.useDelimiter("\n");
		boolean found = false;
		PrintWriter findUserWriter = new PrintWriter(new FileWriter("find_user.txt"));
		while(scan.hasNext()) {
			String userInfo = scan.next();
			String[] userInfoParts = userInfo.split(",");
			num = userInfoParts[0];
			name = userInfoParts[1];
			tel = userInfoParts[2];
			email = userInfoParts[3];
			if(num.equals(search)) {
				found = true;
				findUserWriter.print(num + "," + name + 
						"," + tel + "," + email + "\n");
				break;
			}
		}
		if(!found) {
			System.out.println("사용자 번호 " + num2 + "을 찾을 수 없습니다.");
		}
		findUserWriter.close();
		
		if(scan != null)
			scan.close();
	}
}
