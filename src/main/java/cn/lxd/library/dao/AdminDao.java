package cn.lxd.library.dao;


import cn.lxd.library.entity.Admin;


public interface AdminDao {
	
    //登陆
    public Admin findByName(String name);


}
