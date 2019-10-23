package com.deepexi.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;
import com.deepexi.util.ConverterUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration implements InitializingBean {
    
    @Autowired
    private ConversionService conversionService;

    @Override
    public void afterPropertiesSet() {
        ConverterUtils.setConversionService(conversionService);
    }
            
    
    @Bean
    public ApplicationMetaObjectHandler.RuntimeData runtimeData() {
        return new ApplicationMetaObjectHandler.RuntimeData() {
            @Override
            public String getUserId() {
                return "1";
            }

            @Override
            public String getTenantId() {
                return "1";
            }
        };
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
            

}

