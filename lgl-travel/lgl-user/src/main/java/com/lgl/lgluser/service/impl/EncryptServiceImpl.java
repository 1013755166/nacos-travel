package com.lgl.lgluser.service.impl;

import com.lgl.lgluser.config.EncryptConfigProperties;
import com.lgl.lgluser.service.IEncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptServiceImpl implements IEncryptService {
    @Autowired
    private EncryptConfigProperties encryptConfigProperties; // 属性配置
    private static MessageDigest MD5_DIGEST; // MD5加密处理
    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder(); // 加密器
    static {    // 初始化操作
        try {
            MD5_DIGEST = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getEncryptPassword(String password) {
        String saltPassword = "{" + this.encryptConfigProperties.getSalt() + "}" + password;
        for (int x = 0 ; x < this.encryptConfigProperties.getRepeat(); x ++) {
            saltPassword = BASE64_ENCODER.encodeToString(MD5_DIGEST.digest(saltPassword.getBytes()));
        }
        return saltPassword;
    }
}
