package edu.nuaa.watermeter.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.nuaa.watermeter.pojo.Admin;
import edu.nuaa.watermeter.pojo.CommunityCity;
import edu.nuaa.watermeter.service.AdminService;
import edu.nuaa.watermeter.service.CommunityCityService;
import edu.nuaa.watermeter.utils.RequestUtils;
import edu.nuaa.watermeter.utils.ResponseUtils;

@Controller
@RequestMapping("/main")
public class LoginController {
	@Autowired
	AdminService adminService = null;
	@Autowired
	CommunityCityService communityCityService = null;
	@RequestMapping(value="/validateLogin")
	public void login(HttpServletRequest request, HttpServletResponse response){
		//获取form表单数据
	    String loginObj = RequestUtils.getString(request, "loginObj");
	    String name,pwd;
	    boolean flag = false;
	    if(loginObj==null){
	    	name = request.getParameter("accountNo");
	    	pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd");
	    }else{
	    //JSON字符串序列化成JSON对象
	    	JSONObject loginJosn = JSONObject.parseObject(loginObj);
	    	name = loginJosn.getString("accountNo");
	    	pwd = loginJosn.getString("pwd");
	    }
	    //根据账号查询用户名是否存在
	    Admin admin = adminService.getAdmin(name);
	    JSONObject result = new JSONObject();
	    
	    if (null == admin){
	      result.put("accountMsg", "用户名不存在");
	      flag=true;

	    }else if (!pwd.equals(admin.getPassword())){
	      result.put("pwdMsg", "用户名密码错误");
	      flag=true;
	    }else {
	    	//创建session保存用户名密码
	    	HttpSession session = request.getSession();
	    	session.setAttribute("admin", admin);
	    	result.put("user",admin);
	    }
	    if(loginObj==null && !flag){
		      String cityName = admin.getManageCity();
		      System.out.println(cityName);
		      
		      Map<String, String> locationMap = new HashMap<String, String>();
		      if(!cityName.equals("all")){
		    	  locationMap.put("cityName", cityName);
		      }
			  List<CommunityCity> communityCityList = communityCityService.getCommunityCity(locationMap);
			  JSONArray resultArray = list2JsonArray(communityCityList);
			  String resultStr = resultArray.toJSONString();
			  ResponseUtils.send(response, resultStr);
	    }else{
	    	String resultStr = result.toJSONString();
	    	ResponseUtils.send(response, resultStr);
	    }
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
	      Admin admin = adminService.getAdmin(name);
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
	  
	  @RequestMapping("/registerUser")
	  public ModelAndView registerUser(HttpSession seesion,ModelAndView model){
		  Admin admin = (Admin) seesion.getAttribute("user");
		  //
		  String cityName = admin.getManageCity();
		  System.out.println(cityName);
		  if(!cityName.equals("all")){
			  model.setViewName("NoPermission");
		  }else{
			  model.setViewName("register_user");
		  }
	      return model;
	  }
	  
	  @RequestMapping("/addUser")
	  public ModelAndView addUser(HttpServletRequest request,ModelAndView model){
		  //获取表单数据
		  String name = request.getParameter("name");
		  String password = request.getParameter("password");
		  String email = request.getParameter("email");
		  String phone = request.getParameter("phone");
		  String manageCity = request.getParameter("manageCity");
		  System.out.println(manageCity);
		  
		  Admin admin = new Admin();
		  admin.setName(name);
		  admin.setEmail(email);
		  admin.setPassword(password);
		  admin.setPhone(phone);
		  admin.setManageCity(manageCity);
		  int count = adminService.insertAdmin(admin);
	      //跳转到/jsp/main.jsp页面
	      model.setViewName("main");
	      return model;
	  }
	  
	  @RequestMapping("/manageCommunity.do")
	  public void manageCommunity(HttpSession seesion,ModelAndView model,HttpServletResponse response){
	      Admin admin = (Admin) seesion.getAttribute("user");
	      String cityName = admin.getManageCity();
	      System.out.println(cityName);
	      
	      Map<String, String> locationMap = new HashMap<String, String>();
	      if(!cityName.equals("all")){
	    	  locationMap.put("cityName", cityName);
	      }
		  List<CommunityCity> communityCityList = communityCityService.getCommunityCity(locationMap);
		  JSONArray result = list2JsonArray(communityCityList);
		  String resultStr = result.toJSONString();
		  ResponseUtils.send(response, resultStr);
	  }
	  
	  private JSONArray list2JsonArray(List<CommunityCity> list){
			JSONArray result = new JSONArray();	
			if(list.size()==0){
				JSONObject item = new JSONObject();
				item.put("message", "无地区信息!");
				result.add(item);
			}else{
				for (CommunityCity communityCity : list) {
					JSONObject item = new JSONObject();
					item.put("city_code", communityCity.getCityCode());
					item.put("comunity_code", communityCity.getComunityCode());
					item.put("unit_code", communityCity.getUnitCode());
					item.put("city_name", communityCity.getCityName());
					item.put("community_name", communityCity.getCommunityName());
					item.put("unit_name", communityCity.getUnitName());
					result.add(item);
				}
			}
			return result;
		}
	
}
