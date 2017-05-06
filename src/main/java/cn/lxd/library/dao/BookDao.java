package cn.lxd.library.dao;

import java.util.List;

import cn.lxd.library.entity.Book;

public interface BookDao {
	
	List<Book> find();//显示所有图书
	Book findByBno(String bno);//通过编号查找
	boolean save(Book bean);//添加书籍
	boolean delete(Book bean);//删除书籍
	Book findById(Book bean);//查看书籍，通过id查看的
	boolean update(Book bean);//更新书籍信息
//------------------------------------------------------------------
   

   

    boolean updateRemain(Book bean);

    

    

    
}
