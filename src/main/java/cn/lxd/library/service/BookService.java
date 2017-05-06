package cn.lxd.library.service;


import cn.lxd.library.entity.Book;
import cn.lxd.library.util.Result;

public interface BookService {
	
	public Result findBooks();
	
	public Result findByBno(String book);
	
	public Result save(Book bean);
	
	public Result delete(Book book);
	
	public Result findById(Book book);
	
	public Result update(Book book);
}





