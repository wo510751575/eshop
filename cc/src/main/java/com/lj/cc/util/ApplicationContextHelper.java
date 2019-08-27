package com.lj.cc.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {
	
	private static ApplicationContext atx;

	public static ApplicationContext getApplicationContext() {
		return atx;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		atx = context;
	}

	public static Object getBean(String name) {
		return null == atx ? null : atx.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return null == atx ? null : atx.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return null == atx ? null : atx.getBean(name, requiredType);
	}
}
