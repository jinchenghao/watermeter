package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.nuaa.watermeter.dao.AdminDao;
import edu.nuaa.watermeter.dao.CommunityCityDao;
import edu.nuaa.watermeter.dao.UserDao;
import edu.nuaa.watermeter.pojo.Admin;
import edu.nuaa.watermeter.pojo.CommunityCity;
import edu.nuaa.watermeter.pojo.User;
import edu.nuaa.watermeter.pojo.WmStatus;

public class adminTest {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean(UserDao.class);
		Map<String, String> map = new HashMap<>();
		map.put("cityCode", "05151");
		map.put("communityCode", "00002");
		map.put("unitCode", "007");
		List<User> users = userDao.getUserByLocation(map);
		int count=0;
		for (User user : users) {
			count++;
			List<WmStatus> wmStatus = user.getWmStatus();
			for (WmStatus wmStatus2 : wmStatus) {
				System.out.print(wmStatus2.getMeterAddress()+" ");
			}
			System.out.println();
		}
		System.out.println("×ÜÊýÎª£º"+count);
	}
}
