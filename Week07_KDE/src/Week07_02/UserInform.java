package Week07_02;

import java.io.File;
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
		
		System.out.println("전화번호를 조회할 번호를 입력하세요: ");
		String searchNum = s.next();
		String phoneNum = userMap.get(tel);
		
		if(searchNum != null) {
			System.out.println("해당 번호의 전화번호: " + tel);
		}else {
			System.out.println("전화번호를 찾을 수 없습니다.");
		}
	}
}
