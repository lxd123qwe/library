package cn.lxd.library.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lxd.library.dao.BookDao;
import cn.lxd.library.entity.Book;
import cn.lxd.library.util.Result;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	public Result findBooks() {
		List<Book> books=bookDao.find();
		if(books!=null){
			Result result=new Result();
			result.setStatus(200);
			result.setMsg("加载图书成功");
			result.setData(books);
			//System.out.println(books);
			return result;
		}
		Result result=new Result();
		result.setStatus(400);
		result.setMsg("加载图书失败");
		return result;
	}
	public Result findByBno(String bno) {
		Result result=new Result();
		Book book=bookDao.findByBno(bno);
		if(book!=null){
			result.setStatus(200);
			result.setMsg("查找编号成功");
			result.setData(book);
			return result;
		}
		result.setStatus(400);
		result.setMsg("查找编号失败");
		return result;
	}
	public Result save(Book book) {
		Result result=new Result();
		//System.out.println(book.getBno());
		Book b=new Book();
		//本来想用uuid可是已经写成integer型了，后来想用序列，觉得也挺简单，反正都简单，
		//就用这个了，如果以后有时间再来改
		b.setId((int) (Math.random() * 900000000) + 100000000);
		b.setBno(book.getBno());
		b.setBname(book.getBname());
		b.setTid(book.getTid());
		b.setAuthor(book.getAuthor());
		b.setPrice(book.getPrice());
		b.setTotal(100);
		b.setRemain(book.getRemain());
		b.setCdate(new Date(System.currentTimeMillis()));
		b.setUdate(new Date(System.currentTimeMillis()));
		b.setBrief(book.getBrief());
		b.setYn(1);
		boolean i=bookDao.save(b);
		if(i){
			result.setStatus(400);
			result.setMsg("添加书籍成功");
			return result;
		}
		result.setStatus(500);
		result.setMsg("添加书籍失败");
		return result;
	}
	public Result delete(Book book) {
		Book b=new Book();
		b.setId(book.getId());
		Result result=new Result();
		boolean d=bookDao.delete(b);
		if(d){
			result.setStatus(400);
			result.setMsg("删除成功");
			return result;
		}
		result.setStatus(500);
		result.setMsg("删除失败");
		return result;
	}
	public Result findById(Book book) {
		Result result=new Result();
		Book b=bookDao.findById(book);
		if(b!=null){
		result.setStatus(400);
		result.setMsg("查看完成");
		result.setData(b);
		return result;
		}
		result.setStatus(500);
		result.setMsg("不能查看，");
		return result;
	}
	public Result update(Book book) {
		Result result=new Result();
		boolean b=bookDao.update(book);
		if(b){
			result.setMsg("更新信息成功");
			result.setStatus(400);
			return result;
		}
		result.setMsg("更新信息失败");	
		result.setStatus(500);
		return result;
	}

}





















