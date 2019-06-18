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
		//��ȡform������
	    String loginObj = RequestUtils.getString(request, "loginObj");
	    //JSON�ַ������л���JSON����
	    JSONObject loginJosn = JSONObject.parseObject(loginObj);
	    String name = loginJosn.getString("accountNo");
	    String pwd = loginJosn.getString("pwd");
	    //�����˺Ų�ѯ�û����Ƿ����
	    Admin admin = adminService.getAdmin(name);
	    JSONObject result = new JSONObject();
	    
	    if (null == admin){
	      result.put("accountMsg", "�û���������");
	    }else if (!pwd.equals(admin.getPassword())){
	      result.put("pwdMsg", "�û����������");
	    }else {
	      result.put("user",admin);
	    }
	    String resultStr = result.toJSONString();
	    ResponseUtils.send(response, resultStr);
	}
	
	/**
	   * ��½��ת
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
	      //��ת��/jsp/main.jspҳ��
	      return "redirect:./showMain.do";
	  }
	  @RequestMapping("/showMain")
	  public ModelAndView login(HttpSession seesion,ModelAndView model){
		  Admin admin = (Admin) seesion.getAttribute("user");
		  //System.out.println(admin.getName()+"!!!!!!!!!!!!!!");
	      model.addObject("user", admin);
	      //��ת��/jsp/main.jspҳ��
	      model.setViewName("main");
	      return model;
	  }
	  /**
	   * �˳�
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
