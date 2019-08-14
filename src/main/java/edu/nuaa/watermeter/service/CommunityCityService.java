package edu.nuaa.watermeter.service;

import java.util.List;
import java.util.Map;

import edu.nuaa.watermeter.pojo.CommunityCity;

public interface CommunityCityService {
	public int addCommunityCity(CommunityCity communityCity);
	public int removeCommunityCity(CommunityCity communityCity);
	public int updateCommunityCity(CommunityCity communityCity);
	public List<CommunityCity> getCommunityCity(Map<String, String> locationMap);
	public List<CommunityCity> getCommunityCityByCity(String cityCode);
	public List<CommunityCity> getCommunityCityByCommunity(String communityCode);
	public List<CommunityCity> getCommunityCityByUnit(String unitCode);
}
