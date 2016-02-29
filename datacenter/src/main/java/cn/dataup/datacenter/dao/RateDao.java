package cn.dataup.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;
import cn.dataup.datacenter.entity.ReportAuditRate;

@MyBatisRepository
public interface RateDao {

	List<ReportAuditRate> queryAuditRate(@Param("system_type") String system_type);
	List<ReportAuditRate> queryMonthAuditRate(@Param("system_type") String system_type);
	void updateAuditRate();
	void updateAuditRate1();
	void updateAuditRate2();
	void updateAuditRate3();
	void updateAuditRate4();
	void updateAuditRate5();
	void updateAuditRate6();
}
