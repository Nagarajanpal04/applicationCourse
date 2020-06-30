package io.springbootstarter.book;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookService bookServices;
	
	@RequestMapping("/")
	public String landingPage() {
		return "Spring boot Application has been automated";
	}
	
	@RequestMapping("/book")
	public List<Book> getAllBooks(){
		
		return bookServices.getbook();
	}
	
	@RequestMapping("/book/{bookId}")
	public Book getBooks(@PathVariable String bookId){
		
		return bookServices.getBooks(bookId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/book")
	public void postBook(@RequestBody Book book){
		
		bookServices.postBook(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/book/{bookId}")
	public void deletebook(@PathVariable String bookId){
		
		 bookServices.deletebook(bookId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/book/{bookId}")
	public void updateBook(@RequestBody Book book , @PathVariable String bookId) {
		bookServices.update(book, bookId);
	}
}
