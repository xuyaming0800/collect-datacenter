package cn.dataup.datacenter.dao;

import java.util.List;




import org.apache.ibatis.annotations.Param;

import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;
import cn.dataup.datacenter.entity.MapTask;

@MyBatisRepository
public interface MapTaskDao {

	/**
	 * 
	 * @Title: queryAudited 
	 * @Description: 审核完成(审核通过 失败 申斥)
	 * @param @param status
	 * @param @return 设定文件 
	 * @return List<MapTask> 返回类型 
	 * @throws
	 */
	List<MapTask> queryAudited(@Param("status") int status,@Param("system") int system);
	/**
	 * 
	 * @Title: queryAuditing 
	 * @Description: 审核中
	 * @param @param status
	 * @param @return 设定文件 
	 * @return List<MapTask> 返回类型 
	 * @throws
	 */
	List<MapTask> queryAuditing(@Param("status") int status,@Param("system") int system);


}
