package edu.nuaa.watermeter.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.nuaa.watermeter.pojo.CommunityCity;
@Repository
public interface CommunityCityDao {
	public int insertCommunityCity(CommunityCity communityCity);
	public int deleteCommunityCity(CommunityCity communityCity);
	public int updateCommunityCity(CommunityCity communityCity);
	public List<CommunityCity> getCommunityCity(Map<String, String> locationMap);
	public List<CommunityCity> getCommunityCityByCity(String Cityname);
	public List<CommunityCity> getCommunityCityByCommunity(String Communityname);
	public List<CommunityCity> getCommunityCityByUnit(String Unitname);
}
