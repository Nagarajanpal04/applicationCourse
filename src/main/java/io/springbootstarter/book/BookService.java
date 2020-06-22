package io.springbootstarter.book;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	private List<Book> bookSer =  new ArrayList<>(Arrays.asList(
			new Book("1","Test1","J K Rowling"),
			new Book("2","Test2","Nagaraj."),
			new Book("3","Test3","J K Rowling")
			));
	
	public List<Book> getbook(){
		return bookSer;
	}
	
	public Book getBooks(String id) {
		return bookSer.stream().filter(t -> t.getBookId().equalsIgnoreCase(id)).findFirst().get();
	}
	
	public void postBook(Book book) {
		bookSer.add(book);
	}

	public void deletebook(String bookId) {
		bookSer.removeIf(t -> t.getBookId().equalsIgnoreCase(bookId));
	}

	public void update(Book book, String id) {
		for(int i=0; i<=bookSer.size(); i++) {
			Book b= bookSer.get(i);
			if(b.getBookId().equals(id)) {
				bookSer.set(i, book);
				return;
			}
		}
	}
}
