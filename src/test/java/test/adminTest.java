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
import edu.nuaa.watermeter.pojo.Record;
import edu.nuaa.watermeter.pojo.User;
import edu.nuaa.watermeter.pojo.WmStatus;
import edu.nuaa.watermeter.service.UserService;
import edu.nuaa.watermeter.service.impl.UserServiceImpl;

public class adminTest {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = ctx.getBean(UserDao.class);
		UserService userService = ctx.getBean(UserServiceImpl.class);
		List<User> users = userService.getUserByComunitycode("00032");
		int count=0;
		for (User user : users) {
			count++;
			System.out.println(user.getUserCode());
			/*List<Record> wmStatus = user.getRecordList();
			for (Record wmStatus2 : wmStatus) {
				System.out.print(wmStatus2.getMeterAddres()+" ");
			}
			System.out.println();*/
		}
		System.out.println("×ÜÊýÎª£º"+count);
	}
}
