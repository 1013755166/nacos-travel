package com.lgl.lgluser.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "yyh.security.config.password.encrypt") // 配置前缀
@Component
public class EncryptConfigProperties {
    private Integer repeat; // 定义重复的次数
    private String salt; // 加密的盐值
}
