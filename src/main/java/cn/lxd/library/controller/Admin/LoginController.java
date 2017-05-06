package cn.lxd.library.controller.Admin;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.lxd.library.service.AdminService;
import cn.lxd.library.util.Result;

@Controller
@RequestMapping("user")
public class LoginController {
	@Resource
	private AdminService adminService;//注入
	@RequestMapping("/login.do")
	@ResponseBody//将返回值转result换成JSON输出
	public Result execute(String aname,String password) throws NoSuchAlgorithmException{
		Result result=
					adminService.checkLogin(aname, password);
		return result;
	}
	
}
