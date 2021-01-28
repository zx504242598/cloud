package com.zx.cloud.security.controller;

import com.google.zxing.common.BitMatrix;
import com.zx.cloud.common.result.R;
import com.zx.cloud.security.utils.QrCodeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaoxuan
 * @date 2020-05-29 15:49
 **/
@RestController
@RequestMapping("/tasks")
public class TestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    @GetMapping("/auth/test")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String test(){
        return "test";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/sendMessage")
    public R<?> sendMessage(String message){
        kafkaTemplate.send("my-replicated-topic",message);
        return R.ok();
    }

    @PostMapping("/decodeQR")
    public R<?> decodeQR(MultipartFile multipartFile) throws IOException {
        InputStream inputStream=multipartFile.getInputStream();
        String s = QrCodeUtil.decodeQR(inputStream);

        return R.ok(s);
    }

    @GetMapping("/jumpUrl")
    public String jumpUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("User-Agent").toLowerCase();
        System.out.println(userAgent);
        if (userAgent.indexOf("micromessenger")>0){
            //qrCode("http://qr.liantu.com/api.php?text=wxp://f2f0Cenc3b4cBu9MYKOFNpIsbFMiU42wmzGp",response);
            response.sendRedirect("wxp://f2f0Cenc3b4cBu9MYKOFNpIsbFMiU42wmzGp");
            //return "wxp://f2f0Cenc3b4cBu9MYKOFNpIsbFMiU42wmzGp";
            //http://qr.liantu.com/api.php?text=wxp://f2f0lGxS0y-AT4xJ9IIXI_nKcp3U2b2b_W0L
        }else if (userAgent.indexOf("alipayclient")>0){
            System.out.println("支付宝扫码");
            response.sendRedirect("https://qr.alipay.com/fkx02391scuffzoyjcvetb7");

        }
        return null;
    }

    @GetMapping("/qrCode")
    public void qrCode(String content, HttpServletResponse response) throws IOException {
        String format = "jpg";
        int width = 180;
        int height = 220;
        BitMatrix bitMatrix = QrCodeUtil.setBitMatrix(content, width, height);
        // 可通过输出流输出到页面,也可直接保存到文件
        ByteArrayOutputStream byteArrayOutputStream = null;
        try(OutputStream outputStream=response.getOutputStream()) {
            byteArrayOutputStream = QrCodeUtil.writeToFile(bitMatrix, format, null);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("image/jpg;charset=UTF-8");
            response.setContentLength(byteArrayOutputStream.size());
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (byteArrayOutputStream!=null){
                byteArrayOutputStream.close();
            }

        }
    }

    @GetMapping("/cdx")
    public void qrCode(String text) throws IOException {

    }

}
