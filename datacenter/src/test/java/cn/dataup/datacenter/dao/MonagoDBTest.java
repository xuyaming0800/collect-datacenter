package cn.dataup.datacenter.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.dataup.datacenter.holder.ContextHolder;
import cn.dataup.datacenter.service.DCJobService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml","classpath:applicationContext-mongodb.xml" })
public class MonagoDBTest {

	 @Autowired
	private MongoTemplate mongoTemplate = null;

	@Test
	public void getAllAttr() {
		DCJobService dcJobService=ContextHolder.getApplicationContext().getBean(DCJobService.class);
		dcJobService.getXY();
	}
}
