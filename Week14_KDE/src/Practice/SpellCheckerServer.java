package Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class SpellCheckerServer {
	private SpellChecker spellChecker;
	
	public SpellCheckerServer() { }
	
	public void run() {
		System.out.println("스펠체크 서버입니다.");
		spellChecker = new SpellChecker("words.txt");
		if(spellChecker.isFileRead()) {
			System.out.println("words.txt 읽기 완료");
			new ServerThread().start();
		}
	}
	
	class ServerThread extends Thread{
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(5050);
				while(true) {
					socket = listener.accept();
					System.out.println("클라이언트 연결됨");
					new ServiceThread(socket).start();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			try {
				if(listener != null)
					listener.close();
				if(socket != null)
					socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class SpellChecker{
		private Vector<String> v = new Vector<String>();
		private boolean fileOn = false;
		
		public SpellChecker(String fileName) {
			try {
				Scanner reader = new Scanner(new FileReader(fileName));
				while(reader.hasNext()) {
					String word = reader.nextLine();
					v.add(word);
				}
				reader.close();
				fileOn = true;
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				fileOn = false;
			}
		}
		
		public boolean isFileRead() {
			return fileOn;
		}
		
		public boolean check(String word) {
			if(v.contains(word))
				return true;
			else
				return false;
		}
	}
	
	class ServiceThread extends Thread{
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		public ServiceThread(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					String word = in.readLine();
					boolean res = spellChecker.check(word);
					if(res == true) {
						out.write("YES\n");
						System.out.println("요청단어 " + word + "=YES");
					}
					else {
						out.write("NO\n");
						System.out.println("요청단어 " + word + "=NO");
					}
					out.flush();
				}catch(IOException e) {
					System.out.println("클라이언트 연결 종료");
					try {
						socket.close();
					}catch(IOException e1) {
						e1.printStackTrace();
					}
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SpellCheckerServer checker = new SpellCheckerServer();
		checker.run();
	}
}
