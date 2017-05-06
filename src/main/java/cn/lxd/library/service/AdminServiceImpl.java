package cn.lxd.library.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.lxd.library.dao.AdminDao;
import cn.lxd.library.entity.Admin;
import cn.lxd.library.util.Result;


@Service("AdminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	
	public Result checkLogin(String aname, String password) throws NoSuchAlgorithmException {
		Result result=new Result();
		Admin admin=adminDao.findByName(aname);
		if(admin!=null&&admin.getPassword().equals(password)){
			result.setStatus(200);
			result.setMsg("登陆成功");
			result.setData(admin);//返回的数据是用户id
			return result;
		}
		result.setStatus(400);
		result.setMsg("登陆失败");
		return result;
	}

}

























