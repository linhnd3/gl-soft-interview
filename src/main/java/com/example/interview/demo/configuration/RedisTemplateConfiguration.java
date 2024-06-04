package com.example.interview.demo.configuration;

import java.time.Duration;
import java.util.Collections;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author Cooper (linh.nguyenduy@navercorp.com)
 */
@Configuration
public class RedisTemplateConfiguration {

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
            .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig())
            .transactionAware()
            .withInitialCacheConfigurations(Collections.singletonMap("predefined",
                RedisCacheConfiguration.defaultCacheConfig()
                    .entryTtl(Duration.ofSeconds(100))
                    .disableCachingNullValues()))
            .build();
//        return RedisCacheManager.create(redisConnectionFactory);
    }

}
