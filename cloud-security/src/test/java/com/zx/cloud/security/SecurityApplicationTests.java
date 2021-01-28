package com.zx.cloud.security;

import com.zx.cloud.security.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SecurityApplicationTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void contextLoads() {
        String key = "user:1";
        User user1 = new User();
        user1.setUsername("zxzx").setPassword("123");
        redisTemplate.opsForValue().set(key, user1);
        User user = (User) redisTemplate.opsForValue().get(key);
        log.info("uesr: "+user.toString());

    }

    public static void main(String[] args) {
/*
        String content = "http://demo1.zxzxzx.fun:8080/tasks/jumpUrl";
        String logoPath = "D:/logo.png";
        String format = "jpg";
        int width = 180;
        int height = 220;
        BitMatrix bitMatrix = QrCodeUtil.setBitMatrix(content, width, height);
        // 可通过输出流输出到页面,也可直接保存到文件
        OutputStream outStream = null;
        String path = "d:/qr"+new Date().getTime()+".png";
        try {
            outStream = new FileOutputStream(new File(path));
            QrCodeUtil.writeToFile(bitMatrix, format, outStream, logoPath);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

        //System.out.println(QrCodeUtil.decodeQR(path));
/*        // 添加文字效果
        int fontSize = 12; // 字体大小
        int fontStyle = 1; // 字体风格
        String text = "测试二维码";
        String withTextPath = "d:/text"+new Date().getTime()+".png";
        QrCodeUtil.pressText(text, withTextPath, path, fontStyle, Color.BLUE, fontSize, width, height);*/
    }
}
