package cn.dataup.datacenter.holder;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator {
	private static ServiceLocator serviceLocator;
	static Object obj = new Object();
	private BeanFactory factory = null;

	private ServiceLocator() {
		String[] fa = new String[] { "classpath*:applicationContext*.xml"};
		factory = new ClassPathXmlApplicationContext(fa);
	}

	public static ServiceLocator getInstance() {
		synchronized (obj) {
			if (serviceLocator == null) {
				serviceLocator = new ServiceLocator();
			}
			return serviceLocator;
		}
	}
	public BeanFactory getFactory() {
		return factory;
	}

}
