package org.acme.hibernate.search.elasticsearch.config;

import org.hibernate.search.backend.elasticsearch.client.spi.ElasticsearchHttpClientConfigurer;
import org.hibernate.search.engine.environment.bean.BeanReference;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurationContext;
import org.hibernate.search.engine.environment.bean.spi.BeanConfigurer;

public class MyBeanConfigurer implements BeanConfigurer {
	@Override
	public void configure(BeanConfigurationContext beanConfigurationContext) {
		beanConfigurationContext.assignRole(
				ElasticsearchHttpClientConfigurer.class,
				BeanReference.of( MyHttpClientConfigurer.class )
		);
	}
}
