package edu.nuaa.watermeter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import edu.nuaa.watermeter.pojo.Record;
import edu.nuaa.watermeter.pojo.User;
import edu.nuaa.watermeter.service.AdminService;
import edu.nuaa.watermeter.service.CommunityCityService;
import edu.nuaa.watermeter.service.UserService;
import edu.nuaa.watermeter.utils.RequestUtils;
import edu.nuaa.watermeter.utils.ResponseUtils;

@Controller
@RequestMapping("/main")
public class LoginController {
	@Autowired
	AdminService adminService = null;
	@Autowired
	CommunityCityService communityCityService = null;
	@Autowired
	UserService userService = null;
	@SuppressWarnings("null")
	@RequestMapping(value="/validateLogin")
	public void login(HttpServletRequest request, HttpServletResponse response){
		//获取form表单数据
	    String loginObj = RequestUtils.getString(request, "loginObj");
	    String name,pwd,time = null;
	    int pageNum=1,pageSize=20;
	    boolean flag = false;
	    if(loginObj==null){
	    	name = request.getParameter("accountNo");
	    	pwd = request.getParameter("pwd")==null?"":request.getParameter("pwd");
	    	time = request.getParameter("date");
	    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
	    	pageSize = Integer.parseInt(request.getParameter("pageSize"));
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
		      List<Record> resultList = new ArrayList<>();
			  List<CommunityCity> communityCityList = communityCityService.getCommunityCity(locationMap);
			  List<User> users = new ArrayList<>();
			  List<String> cityCodeList = new ArrayList<>();
			  for (CommunityCity communityCity : communityCityList) {
				  if(cityCodeList.contains(communityCity.getCityCode())) continue;
				  else{
					  cityCodeList.add(communityCity.getCityCode());
					  System.out.println(communityCity.getCityName());
					  //System.out.println(userService.getUserByComunitycode(communityCity.getComunityCode()).size());
					  users.addAll(userService.getUserByCitycode(communityCity.getCityCode()));
				  }
			  }
			  long time1 = System.currentTimeMillis();
			  for (User user : users) {
				  //System.out.println("User:"+user.getComunityCode());
					List<Record> records = user.getRecordList();
					//System.out.println(resultList.size());
					for (Record record : records) {
						if(time == null) {
							resultList.addAll(records);
							break;
						}
						if(record.getRecordTime().contains(time)){
							resultList.add(record);
						}
					}
				}
			  long time2 = System.currentTimeMillis();
			  int time3 = (int) ((time2 - time1)/1000);
		      System.out.println("执行了："+time3+"秒！");

			  JSONArray recordResultArray = Recordlist2JsonArray(resultList);
			  String resultStr = recordResultArray.toJSONString();
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
	  
	  private JSONArray Recordlist2JsonArray(List<Record> records){
			JSONArray result = new JSONArray();	
			if(records.size()==0){
				JSONObject item = new JSONObject();
				item.put("message", "该地区无记录!");
				result.add(item);
			}else{
				for (Record record : records) {
					JSONObject item = new JSONObject();
					item.put("meter_address", record.getMeterAddres());
					item.put("meter_simccid", record.getMeterSimccid());
					item.put("record_time", record.getRecordTime());
					item.put("battery_voltage", record.getBatteryVoltage());
					item.put("signal_indicator", record.getSignalIndicator());
					item.put("meter_gray_image", record.getMeterGrayImage());
					item.put("meter_digit_image", record.getMeterDigitImage());
					item.put("recognize_time", record.getRecognizeTime());
					item.put("meter_reading", record.getMeterReading());
					result.add(item);
				}
			}
			return result;
		}
	  private List removeDuplicate(List list) {   
		    HashSet h = new HashSet(list);   
		    list.clear();   
		    list.addAll(h);   
		    return list;   
		} 
	
}
