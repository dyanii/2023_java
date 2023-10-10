package Week05_03;

import java.util.Scanner;

public class BookArrayListTest {
	public static void main(String[] args) {
		BookArrayList bookArrayList = new BookArrayList();
		Scanner scanner = new Scanner(System.in);
		
		Book book1 = new Book(0001, "파우스트");
		Book book2 = new Book(0002, "황무지");
		Book book3 = new Book(0003, "변신");
		Book book4 = new Book(0004, "픽션들");
		Book book5 = new Book(0005, "토이스토리");
		
		bookArrayList.addBook(book1);
		bookArrayList.addBook(book2);
		bookArrayList.addBook(book3);
		bookArrayList.addBook(book4);
		bookArrayList.addBook(book5);
		
		bookArrayList.showAllBook();
		
		//키보드로 위치와 책 ID, 책 제목을 입력 받아서 출력
		System.out.println("도서를 추가할 위치를 입력: ");
		int insertIndex = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("책 ID 입력: ");
		int bookId = scanner.nextInt();
		
		System.out.println("책 제목 입력: ");
		String title = scanner.next();
		
		Book newBook = new Book(bookId, title);
		bookArrayList.insertBook(insertIndex, newBook);
		
		bookArrayList.showAllBook();
		
		scanner.close();
	}
}
