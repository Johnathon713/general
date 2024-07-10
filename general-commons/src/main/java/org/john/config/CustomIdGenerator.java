package org.john.config;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Johnathon
 */
@Component
@RequiredArgsConstructor
public class CustomIdGenerator implements IdentifierGenerator {
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Number nextId(Object entity) {
        return stringRedisTemplate.opsForValue().increment(StrUtil.format("generator:id:{}", entity.getClass().getName()), RandomUtil.randomLong(1L, 1000L));
    }
}
