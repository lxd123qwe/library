package test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lxd.library.entity.Book;
import cn.lxd.library.service.BookService;
import cn.lxd.library.util.Result;


public class TestBookService {

	@Test
	public void find(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		System.out.println(bookService);
		Result books=bookService.findBooks();
		System.out.println(books);
	}
	
	@Test
	public void findByBno(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		Result books=bookService.findByBno("100001");
		System.out.println(books);
	}
	@Test
	public void save(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		
		Book b=new Book(); 
		//b.setId((int) (Math.random() * 900000000) + 100000000);
		b.setBno("100009");
		b.setBname("i");
		b.setTid(1);
		b.setAuthor("me");
		b.setPrice(99.8);
		//b.setTotal(100);
		b.setRemain(100);
		//b.setCdate(new Date(System.currentTimeMillis()));
		//b.setUdate(new Date(System.currentTimeMillis()));
		//b.setYn(1);
		Result result=bookService.save(b);
		System.out.println(result);
	}
	@Test
	public void delete(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		Book book=new Book();
		book.setId(447221404);
		Result r=bookService.delete(book);
		System.out.println(r);
	}
	@Test
	public void findById(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		Book book=new Book();
		book.setId(1);
		Result r=bookService.findById(book);
		System.out.println(r);
	}
	@Test
	public void update(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookService bookService=ac.getBean("bookService",BookService.class);
		Book book=new Book();
		book.setId(393994258);
		book.setBname("爱");
		Result result=bookService.update(book);
		System.out.println(result);
	}
}




















