package org.john.general.mybatisPlus.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Johnathon
 */
@Component
@RequiredArgsConstructor
public class CustomIdGenerator implements IdentifierGenerator {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Number nextId(Object entity) {
        Random random = new Random(10L);
        return stringRedisTemplate.opsForValue().increment("generator:id:" + entity.getClass().getName(), random.nextLong());
    }

    public static void main(String[] args) {
        Random random = new Random(10L);
        System.out.println(random.nextLong());
    }
}
