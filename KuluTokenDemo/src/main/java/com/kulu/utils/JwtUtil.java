package com.kulu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;


/**
 * JWT 工具類
 */
public class JwtUtil {
    
    // 有效期為
    public static final Long JWT_TTL = 60 * 60 * 1000L; // 60 * 60 * 1000 一個小時
    // 設置秘鑰明文
    public static final String JWT_KEY = "kulujian";

    public static String getUUID() {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     *  生成 JWT
     *  @param subject token 中要存放的數據 (json 格式)
     *  @return
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());    // 設置過期時間
        return builder.compact();
    }
    
    /**
     *  生成 JWT
     *  @param subject token 中要存放的數據 (json 格式)
     *  @param ttliMillis token 超時時間
     *  @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());    // 設置過期時間
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)                // 唯一的ID
                .setSubject(subject)        // 主題 可以是JSON數據
                .setIssuer("kj")            // 簽發者
                .setIssuedAt(now)           // 簽發時間
                .signWith(signatureAlgorithm, secretKey)    // 使用 HS256 對稱加密算法簽名，第二個參數為秘鑰
                .setExpiration(expDate);
    }

    /**
     * 創建 token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);    // 設置過期時間
        return builder.compact();
    }
    
    public static void main(String[] args) throws Exception {
//        String token = 
//            "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjYWM2ZDVhZi1mNjVlLTQ0MDAtYjcxMi0zYWEwOGIyOTIwYjQiLCJzdWIiOiJzZyIsImlzcyI6InNnIiwiaWF0IjoxNjM4MTA2NzEyLCJleHAiOjE2MzgxMTAzMTJ9.JVsSbkP94wuczb4QryQbAke3ysBDIL5ou8fWsbt_ebg";
//        Claims claims = parseJWT(token);
    	String jwt = createJWT("2123");
    	System.out.println(jwt);
//        System.out.println(claims);
    }

    /**
     * 生成加密後的秘鑰 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key =  new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     *
     * @param jwet
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}