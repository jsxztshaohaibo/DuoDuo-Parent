package com.jsxztshaohaibo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
 
import java.util.*;
 
/**
 * 聚合各个服务的swagger接口
 */
@Component
public class DuoduoSwaggerResourceProvider implements SwaggerResourcesProvider {
    /**
     * swagger2默认的url后缀
     */
    private static final String SWAGGER2URL = "/v2/api-docs";
 
    /**
     * 网关路由
     */
    private final RouteLocator routeLocator;
 
    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String self;
 
    @Autowired
    public DuoduoSwaggerResourceProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }
 
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routeHosts = new ArrayList<>();
        //取出gateway的route
        // 获取所有可用的host：serviceId
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> !self.equals(route.getUri().getHost()))
                .subscribe(route -> routeHosts.add(route.getUri().getHost()));

/*
        routeLocator.getRoutes().filter(route -> route.getId() != null)
                .filter(route -> !self.equals(route.getId()))
                .subscribe(route -> routeHosts.add(route.getId()));*/

        // 记录已经添加过的server，存在同一个应用注册了多个服务在eureka上
        Set<String> dealed = new HashSet<>();
        routeHosts.forEach(instance -> {
            // 拼接url
            String url = "/" + instance.toLowerCase() + SWAGGER2URL;
            if (!dealed.contains(url)) {
                dealed.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        return resources;
    }


}