package Collection;

import java.util.ArrayList;

public class BookArrayList {
	private ArrayList<Book> arraylist;
	
	public BookArrayList() {
		arraylist = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		arraylist.add(book);
	}
	
	public boolean removeBook(int BookId) {
		for(int i=0; i< arraylist.size(); i++) {
			Book book = arraylist.get(i);
			int tempId = book.getBookId();
			if(tempId == BookId) {
				arraylist.remove(i);
				return true;
			}
		}
		System.out.println(BookId+"가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllBook() {
		for(Book book : arraylist) {
			System.out.println(book);
		}
		System.out.println();
	}
}
