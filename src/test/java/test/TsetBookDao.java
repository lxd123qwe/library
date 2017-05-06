package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lxd.library.dao.BookDao;
import cn.lxd.library.entity.Book;

public class TsetBookDao {
	@SuppressWarnings("resource")
	@Test
	public void find(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
		System.out.println(bookDao);
		List<Book>books=bookDao.find();
		for(Book book:books){
			System.out.println(book.getBname()+":"+
								book.getCdate());
		}
	}
	@Test
	public void findByBno(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
		System.out.println(bookDao);
		Book books=bookDao.findByBno("100001");
		System.out.println(books);
	}
	@Test
	public void save() throws ParseException{
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date=new Date(System.currentTimeMillis());
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+1);
        Book book=new Book();
		book.setId(6);
		book.setBno("100004");
		book.setBname("123");
		book.setTid(1);
		book.setAuthor("xxx");
		book.setPrice(99.9);
		book.setTotal(50);
		book.setRemain(8);
		book.setBrief("nnn");
		book.setCdate(date);
		book.setUdate(date);
	    book.setYn(1);
	    boolean i=bookDao.save(book);
		System.out.println(i);
	}
	@Test
	public void delete(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
		Book bean=new Book();
		bean.setId(915735340);
		boolean d=bookDao.delete(bean);
		System.out.println(d);
	}
	@Test
	public void findById(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
		Book bean=new Book();
		bean.setId(1);
		Book b=bookDao.findById(bean);
		System.out.println(b);
	}
	@Test
	public void update(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		BookDao bookDao=ac.getBean("bookDao",BookDao.class);
		Book bean=new Book();
		boolean b=bookDao.update(bean);
		System.out.println(b);
	}

}
