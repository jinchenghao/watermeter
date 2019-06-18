package edu.nuaa.watermeter.dao;

import org.springframework.stereotype.Repository;

import edu.nuaa.watermeter.pojo.Admin;
@Repository
public interface AdminDao {
	public int insertAdmin(Admin role);
	public int deleteAdmin(Admin role);
	public int updateAdmin(Admin role);
	public Admin getAdmin(String name);
}
