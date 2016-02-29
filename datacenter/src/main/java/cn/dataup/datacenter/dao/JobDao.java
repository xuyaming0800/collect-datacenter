package cn.dataup.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;
import cn.dataup.datacenter.entity.JobUserInfo;

@MyBatisRepository
public interface JobDao {

	List<JobUserInfo> queryJobMobileUserRegs();

	void updateUserWhereCity(@Param("city") String city,
			@Param("mobile") String mobile, @Param("userName") String userName);

	List<JobUserInfo> queryJobUserIdCard();

	void updateUserAgeByIdCard(@Param("age") int age,
			@Param("userName") String userName);

	int isExistTaskPoints(@Param("taskId") String taskId,
			@Param("lat") String lat,@Param("lon") String lon);
	void insertTaskPoints(@Param("taskId") String taskId,
			@Param("lat") String lat,@Param("lon") String lon);
	
}
