package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lxd.library.dao.AdminDao;
import cn.lxd.library.entity.Admin;

public class TsetAdminDao {
	@SuppressWarnings("resource")
	@Test
	public void find(){
		String config="ApplicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		AdminDao adminDao=ac.getBean("adminDao",AdminDao.class);
		System.out.println(adminDao);
		Admin admin=adminDao.findByName("admin");
		System.out.println(admin);
		
	
	}
	

}
