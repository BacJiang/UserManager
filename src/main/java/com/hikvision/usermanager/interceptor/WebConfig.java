package com.hikvision.usermanager.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	private ApplicationContext applicationContext;
	
	public WebConfig() {
		super();
	}
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("111");
        //拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/tologin");
        super.addInterceptors(registry);
    }
}
