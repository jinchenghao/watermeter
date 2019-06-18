package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.nuaa.watermeter.dao.AdminDao;
import edu.nuaa.watermeter.dao.CommunityCityDao;
import edu.nuaa.watermeter.pojo.Admin;
import edu.nuaa.watermeter.pojo.CommunityCity;

public class adminTest {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminDao adminDao = ctx.getBean(AdminDao.class);
		CommunityCityDao communityCityDao = ctx.getBean(CommunityCityDao.class);
		Admin admin = adminDao.getAdmin("admin");
		List<CommunityCity> communityCityList = communityCityDao.getCommunityCityByCity("’ÚΩ≠æ‰»›");
		for (CommunityCity communityCity : communityCityList) {
			System.out.println(communityCity.getCityName()+" "+communityCity.getCommunityName()+" "+communityCity.getUnitName());
		}
		System.out.println(admin.getPassword());
	}
}
