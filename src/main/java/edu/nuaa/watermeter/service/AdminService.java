package edu.nuaa.watermeter.service;

import edu.nuaa.watermeter.pojo.Admin;

public interface AdminService {
	public Admin getAdmin(String name);
	public int insertAdmin(Admin admin);
}
