package org.john.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author Johnathon
 */
@Slf4j
@Component
public class RequestConsumingFilter implements GlobalFilter, Ordered {
    private static final String BEGIN_VISIT_TIME = "begin_visit_time";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());
        try {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
                if (beginVisitTime != null) {
                    URI uri = exchange.getRequest().getURI();
                    log.info("----------------开始----------------");
                    log.info("访问接口主机: " + uri.getHost());
                    log.info("访问接口端口: " + uri.getPort());
                    log.info("访问接口URL: " + uri.getPath());
                    log.info("访问接口参数: " + uri.getRawQuery());
                    log.info("访问接口时长: " + (System.currentTimeMillis() - beginVisitTime) + "ms。");
                    log.info("================结束================");
                }
            }));
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
