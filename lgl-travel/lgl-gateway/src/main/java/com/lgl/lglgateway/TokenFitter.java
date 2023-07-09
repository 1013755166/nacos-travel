//package com.lgl.lglgateway;
//
//import com.lgl.lglcommon.util.JwtUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import io.jsonwebtoken.Claims;
//import org.springframework.util.StringUtils;
//@Component
//@Slf4j
//public class TokenFitter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //获取request response
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//        //获取请求url 打印！
//        String path = request.getURI().getPath();
////        System.out.println(path);
//        if(path.startsWith("/client/tologin")||path.startsWith("/client/desAll")||path.startsWith("/client/images/")||path.startsWith("/client/css/")||path.startsWith("/client/fonts/")||path.startsWith("/client/js/")){
////            System.out.println("Token登录 网关同行！！");
//            return chain.filter(exchange);
//        }
//        //获取请求中的Token       从请求头中获取Token
//        String token = request.getHeaders().getFirst("token");
//        //不存在 则从请求中查找, 有没有Token
//        if(StringUtils.isEmpty(token)){
//            token=request.getQueryParams().getFirst("token");
//        }
//        //还不存在则,拦截器拦截！
//        if(StringUtils.isEmpty(token)){
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        try {
//            //验证Token 是否存在/合法...
//            Claims claims = JwtUtil.parseJWT(token);        //不合法出现异常,也直接请求拦截！！
//        } catch (Exception e){
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        //以上都成立, 放行！！
//        return chain.filter(exchange);
//    }
//    //过滤顺序级别
//    @Override
//    public int getOrder(){
//        return 0;
//    }
//}
