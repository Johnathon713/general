package org.john.general.mybatisPlus.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author llxx
 */
@Component
@RequiredArgsConstructor
public class CustomIdGenerator implements IdentifierGenerator {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Number nextId(Object entity) {
        Random random = new Random();
        return stringRedisTemplate.opsForValue().increment("generator:id:" + entity.getClass().getName(), random.nextLong(1000));
    }
}
