package com.dataup.dc.web.base.security.service;

import java.util.List;
import java.util.Map;

 
/**
 * 
 * @ClassName: UserService 
 * @Description: 用户登录 
 * @author zhanqiao.huang
 * @date 2015年9月7日 下午3:53:29
 */
public interface UsersService {
	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param username
	 * @return
	 */
	public Map<String, Object> queryInfoByUserName(String username)
			throws Exception;

	/**
	 * 根据用户查询角色信息
	 * 
	 * @param username
	 * @return
	 */
	public List<String> queryRolesByUserName(String username) throws Exception;

	/**
	 * 根据用户信息查询权限信息
	 * 
	 * @param username
	 * @return
	 */
	public List<String> queryPermissionsByUserName(String username)
			throws Exception;
	
	
}
