package edu.nuaa.watermeter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu.nuaa.watermeter.pojo.CommunityCity;
import edu.nuaa.watermeter.service.CommunityCityService;
import edu.nuaa.watermeter.utils.ResponseUtils;

@Controller
@RequestMapping("/communitycity")
public class CommunityCityController {
	@Autowired
	CommunityCityService communityCityService = null;
	@RequestMapping("/city")
	public void getCity(@RequestParam(value="cityName",required=false) String cityName, @RequestParam(value="communityName",required=false) String communityName,
			@RequestParam(value="unitName",required=false) String unitName, HttpServletResponse response){
		Map<String, String> locationMap = new HashMap<String, String>();
		locationMap.put("cityName", cityName);
		locationMap.put("communityName", communityName);
		locationMap.put("unitName", unitName);
		List<CommunityCity> communityCityList = communityCityService.getCommunityCity(locationMap);
		JSONArray result = list2JsonArray(communityCityList);
		String resultStr = result.toJSONString();
	    ResponseUtils.send(response, resultStr);
	}
	
	@RequestMapping("/citycode")
	//public void getCity()
	
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
}
