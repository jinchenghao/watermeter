package edu.nuaa.watermeter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nuaa.watermeter.dao.AdminDao;
import edu.nuaa.watermeter.pojo.Admin;
import edu.nuaa.watermeter.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao=null;
	@Override
	public Admin getAdmin(String name) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(name);
	}
	@Override
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.insertAdmin(admin);
	}
	
}
