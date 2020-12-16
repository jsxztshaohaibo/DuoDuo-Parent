package com.jsxztshaohaibo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableElasticsearchRepositories(basePackages ={"com.jsxztshaohaibo.mapper.ESMapper"})
public class ESApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESApplication.class, args);
	}
}
