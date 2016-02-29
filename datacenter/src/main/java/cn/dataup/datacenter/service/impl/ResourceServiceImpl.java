package cn.dataup.datacenter.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dataup.datacenter.entity.ResultEntity;
import cn.dataup.datacenter.service.ResourceService;
import cn.dataup.datacenter.util.HttpClientUtil;
import cn.dataup.datacenter.util.PropConstants;
import cn.dataup.datacenter.util.PropertiesConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Override
	public List<String> queryRolesByUserName(String username) {
		try {
			String role_url = PropertiesConfig
					.getProperty(PropConstants.GET_DC_ROLE_URL);
			role_url = role_url + "&username=" + username;

			String role_json = HttpClientUtil.get(role_url, null);
			ObjectMapper objectMapper = new ObjectMapper();
			ResultEntity resultEntity = objectMapper.readValue(role_json,
					ResultEntity.class);
			List<String> info = (List<String>) resultEntity.getInfo();
			return info;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<String> queryPermissionsByUserName(String username) {
		try {
			String role_url = PropertiesConfig
					.getProperty(PropConstants.GET_DC_PERMISSION_URL);
			role_url = role_url + "&username=" + username;

			String role_json = HttpClientUtil.get(role_url, null);
			ObjectMapper objectMapper = new ObjectMapper();

			ResultEntity resultEntity = objectMapper.readValue(role_json,
					ResultEntity.class);

			List<String> info = (List<String>) resultEntity.getInfo();
			return info;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
