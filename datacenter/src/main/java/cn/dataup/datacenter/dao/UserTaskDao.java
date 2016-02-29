package cn.dataup.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;
import cn.dataup.datacenter.entity.RegsUser;
import cn.dataup.datacenter.entity.RegsUserDateUp;
import cn.dataup.datacenter.entity.RegsUserInfo;
import cn.dataup.datacenter.entity.UserTaskDetail;

/**
 * 
 * @ClassName: UserTaskDao
 * @Description: 采集用户维度-数据层
 * @author zhanqiao.huang huangzhanqiao@dataup.cn
 * @date 2015年6月25日 上午10:40:39
 */

@MyBatisRepository
public interface UserTaskDao {

	/**
	 * 
	 * @Title: fecthUserCollectQty
	 * @Description: 获取用户采集量
	 * @param @return 设定文件
	 * @return List<UserTaskDetail> 返回类型
	 * @throws
	 */
	List<UserTaskDetail> fecthUserCollectQty();

	Integer findMaxRegsUpDay(@Param(value = "year") Integer year,
			@Param(value = "month") Integer month,
			@Param(value = "day") Integer day);

	RegsUser findUserRegsByKey(@Param(value = "key") Integer key);

	List<RegsUserDateUp> findUserRegsIdByTime(
			@Param(value = "before") Integer before,
			@Param(value = "now") Integer now);

	List<RegsUserInfo> findRegsUserInfoListByKey(Integer userRegsKye);

	/*
	 * void insertOriginalCoordinates(@Param(value = "audit_id") String
	 * audit_id,
	 * 
	 * @Param(value = "originalCoordinates") Double[] originalCoordinates);
	 * 
	 * void insertCollectAuditImage(@Param(value = "audit_id") String audit_id,
	 * 
	 * @Param(value = "images") List<CollectAuditImage> images);
	 * 
	 * void insertCollectAuditSpecimenImage(
	 * 
	 * @Param(value = "audit_id") String audit_id,
	 * 
	 * @Param(value = "images") List<CollectAuditSpecimenImage> images);
	 * 
	 * CollectAudit selectCollectAuditById(@Param(value = "id") String id,
	 * 
	 * @Param(value = "system_type") long system_type);
	 * 
	 * List<CollectAudit> selectCollectAuditByIds( List<Map<String, Object>>
	 * taskList);
	 * 
	 * void audit(@Param(value = "id") String bsTaskId,
	 * 
	 * @Param(value = "flag") boolean flag);
	 * 
	 * void insertHistory(CollectAuditLogs collectAuditLogs);
	 * 
	 * List<CollectAuditLogs> findHistory(
	 * 
	 * @Param(value = "audit_id") String audit_id);
	 * 
	 * List<CollectAuditLogs> findMyselfInvolvedTask(
	 * 
	 * @Param(value = "userName") String userName,
	 * 
	 * @Param(value = "bsType") Integer bsType,
	 * 
	 * @Param(value = "type") Integer type,
	 * 
	 * @Param(value = "page") Integer page,
	 * 
	 * @Param(value = "size") Integer size);
	 * 
	 * List<CollectAuditImage> findUserPhotos(
	 * 
	 * @Param(value = "bsTaskId") String bsTaskId);
	 * 
	 * List<Double> findOriginalCoordinate(@Param(value = "bsTaskId") String
	 * bsTaskId);
	 * 
	 * List<CollectAuditSpecimenImage> findAuditSpecimenImageByTaskId(
	 * 
	 * @Param(value = "bsTaskId") String bsTaskId);
	 * 
	 * int findGISType(@Param(value = "system_type") int system_type);
	 * 
	 * CollectAuditLogs findHistoryDtailByBsTaskId(
	 * 
	 * @Param(value = "bsTaskId") String bsTaskId);
	 * 
	 * void updateStatus(@Param(value = "bsTaskId") String bsTaskId,
	 * 
	 * @Param(value = "status") Integer status);
	 */

}
