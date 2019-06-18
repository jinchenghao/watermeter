package edu.nuaa.watermeter.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.nuaa.watermeter.pojo.Admin;
import edu.nuaa.watermeter.service.AdminService;
import edu.nuaa.watermeter.utils.RequestUtils;
import edu.nuaa.watermeter.utils.ResponseUtils;

@Controller
@RequestMapping("/main")
public class LoginController {
	@Autowired
	AdminService adminService = null;
	@RequestMapping("/validateLogin")
	public void login(HttpServletRequest request, HttpServletResponse response){
		//获取form表单数据
	    String loginObj = RequestUtils.getString(request, "loginObj");
	    //JSON字符串序列化成JSON对象
	    JSONObject loginJosn = JSONObject.parseObject(loginObj);
	    String name = loginJosn.getString("accountNo");
	    String pwd = loginJosn.getString("pwd");
	    //根据账号查询用户名是否存在
	    Admin admin = adminService.getAdmin(name);
	    JSONObject result = new JSONObject();
	    
	    if (null == admin){
	      result.put("accountMsg", "用户名不存在");
	    }else if (!pwd.equals(admin.getPassword())){
	      result.put("pwdMsg", "用户名密码错误");
	    }else {
	      result.put("user",admin);
	    }
	    String resultStr = result.toJSONString();
	    ResponseUtils.send(response, resultStr);
	}
	
	/**
	   * 登陆跳转
	   * @param request
	     * @param model
	     * @return
	   */
	  @RequestMapping("/successLogin")
	  public String login(HttpSession session, HttpServletRequest request){
	      String name = RequestUtils.getString(request, "accountNo");
	      String pwd = RequestUtils.getString(request, "pwd");
	      Admin admin = new Admin();
	      admin.setName(name);
	      admin.setPassword(pwd);
	      session.setAttribute("user", admin);
	      //跳转到/jsp/main.jsp页面
	      return "redirect:./showMain.do";
	  }
	  @RequestMapping("/showMain")
	  public ModelAndView login(HttpSession seesion,ModelAndView model){
		  Admin admin = (Admin) seesion.getAttribute("user");
		  //System.out.println(admin.getName()+"!!!!!!!!!!!!!!");
	      model.addObject("user", admin);
	      //跳转到/jsp/main.jsp页面
	      model.setViewName("main");
	      return model;
	  }
	  /**
	   * 退出
	   * @param request
	     * @param model
	     * @return
	   */
	  @RequestMapping("/loginOut")
	  public ModelAndView loginOut(){
		ModelAndView mav = new ModelAndView("redirect:../login.jsp");
		return mav;
	  }
	
}
