package com.example.interview.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cooper (linh.nguyenduy@navercorp.com)
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;

    @Cacheable(value = {"userCached"}, key = "#countResult", cacheManager = "redisCacheManager")
    public String getUser(int countResult) {
        final String API_URL = "https://randomuser.me/api/?results=" + countResult;
        var result = restTemplate.getForEntity(API_URL, String.class);
        return result.getBody();
    }

    @CacheEvict(value = {"userCached"}, key = "#countResult", cacheManager = "redisCacheManager")
    public void updateUser(int countResult) {
        // do update user then evict
    }
}
