package com.org.auto_mendes_back_end_java.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CachingConfig {
	
	@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        
        cacheManager.setCaches(Arrays.asList(
        		new CaffeineCache("employee", 
        				Caffeine.newBuilder()
        				.expireAfterWrite(3, TimeUnit.DAYS)
        				.initialCapacity(50)
        				.build())
          )
        );
        
        return cacheManager;
    }
	
}