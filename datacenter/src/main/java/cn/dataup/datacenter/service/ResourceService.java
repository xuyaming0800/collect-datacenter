package cn.dataup.datacenter.service;

import java.util.List;

/**
 * 获取用户相关的，菜单，角色，权限信息
 * @author chunsheng.zhang
 *
 */
public interface ResourceService {
	
	/**
	 * 根据用户查询角色信息
	 * @param username
	 * @return
	 */
	public List<String> queryRolesByUserName(String username);
	
	
	/**
	 * 根据用户信息查询权限信息
	 * @param username
	 * @return
	 */
	public List<String> queryPermissionsByUserName(String username);
	
}
