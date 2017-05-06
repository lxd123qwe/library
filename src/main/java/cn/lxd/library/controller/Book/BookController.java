package cn.lxd.library.controller.Book;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lxd.library.entity.Book;
import cn.lxd.library.service.BookService;
import cn.lxd.library.util.Result;

@Controller
@RequestMapping("book")
public class BookController {

	@Resource
	private BookService bookService;//注入
	
	@RequestMapping("/find.do")
	@ResponseBody//将返回值转result换成JSON输出
	public Result execute() throws NoSuchAlgorithmException{
		Result result=
					bookService.findBooks();
		return result;
	}
	
	@RequestMapping("/findByBno.do")
	@ResponseBody//将返回值转result换成JSON输出
	public Result execute(String bno) throws NoSuchAlgorithmException{
		Result result=
					bookService.findByBno(bno);
		return result;
	}
	@RequestMapping("/save.do")
	@ResponseBody//将返回值转result换成JSON输出
	public Result execute(Book book) throws NoSuchAlgorithmException{
		Result result=
					bookService.save(book);
		return result;
	}
	@RequestMapping("/del.do")
	@ResponseBody
	public Result executedel(Book id){
		System.out.println("====删除====="+id);
		Result result=bookService.delete(id);
		return result;
	}
	@RequestMapping("/findById.do")
	@ResponseBody
	public Result executede2(Book id){
		//System.out.println("====查看====="+id);
		Result result=bookService.findById(id);
		return result;
	}
	@RequestMapping("/update.do")
	@ResponseBody
	public Result executeupdate(Book book){
		Result result=bookService.update(book);
		
		return result;
	}
	
	
}

































