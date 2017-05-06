package cn.lxd.library.service;

import java.security.NoSuchAlgorithmException;

import cn.lxd.library.util.Result;


public interface AdminService {

	//检查登陆用户名密码
	public Result checkLogin(String aname,String password) throws NoSuchAlgorithmException;
	
}
