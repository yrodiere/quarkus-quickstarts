package org.acme.hibernate.search.elasticsearch.config;

import org.hibernate.search.backend.elasticsearch.client.spi.ElasticsearchHttpClientConfigurer;
import org.hibernate.search.engine.cfg.spi.ConfigurationPropertySource;

import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;

public class MyHttpClientConfigurer implements ElasticsearchHttpClientConfigurer {
	@Override
	public void configure(HttpAsyncClientBuilder httpAsyncClientBuilder,
			ConfigurationPropertySource configurationPropertySource) {
		throw new IllegalStateException( "IT WORKED" );
	}
}
