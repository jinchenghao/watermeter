package edu.nuaa.watermeter.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nuaa.watermeter.dao.CommunityCityDao;
import edu.nuaa.watermeter.pojo.CommunityCity;
import edu.nuaa.watermeter.service.CommunityCityService;
@Service
public class CommunityCityServiceImpl implements CommunityCityService{

	@Autowired
	CommunityCityDao communityCityDao=null;
	@Override
	public int addCommunityCity(CommunityCity communityCity) {
		// TODO Auto-generated method stub
		return communityCityDao.insertCommunityCity(communityCity);
	}

	@Override
	public int removeCommunityCity(CommunityCity communityCity) {
		// TODO Auto-generated method stub
		return communityCityDao.deleteCommunityCity(communityCity);
	}

	@Override
	public int updateCommunityCity(CommunityCity communityCity) {
		// TODO Auto-generated method stub
		return communityCityDao.updateCommunityCity(communityCity);
	}

	@Override
	public List<CommunityCity> getCommunityCity(Map<String, String> locationMap) {
		// TODO Auto-generated method stub
		List<CommunityCity> communityCityList=communityCityDao.getCommunityCity(locationMap);
		return communityCityList;
	}
	
	@Override
	public List<CommunityCity> getCommunityCityByCity(String cityCode) {
		// TODO Auto-generated method stub
		List<CommunityCity> communityCityList=communityCityDao.getCommunityCityByCity(cityCode);
		return communityCityList;
	}

	@Override
	public List<CommunityCity> getCommunityCityByCommunity(String communityCode) {
		// TODO Auto-generated method stub
		List<CommunityCity> communityCityList=communityCityDao.getCommunityCityByCommunity(communityCode);
		return communityCityList;
	}

	@Override
	public List<CommunityCity> getCommunityCityByUnit(String unitCode) {
		// TODO Auto-generated method stub
		List<CommunityCity> communityCityList=communityCityDao.getCommunityCityByUnit(unitCode);
		return communityCityList;
	}

}
