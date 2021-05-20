package com.xxxx.server.config.security.component;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "creater";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUerNameFromToken(String token){
        String username;
        try {
            Claims claims =  getClaimFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 是否是有效token，用户名相同且没过期
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String userName = getUerNameFromToken(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

    /**
     * 判断token是否可以被刷新  = 过期了
     * @param token
     * @return
     */
    public boolean canRefres(String token){
        return !isTokenExpired(token);
    }

    public String refreshToken(String token){
        Claims claims = getClaimFromToken(token);
        claims.put(CLAIM_KEY_CREATED,  new Date());
        return generateToken(claims);
    }

    /**
     * 判断这个token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expireDate =  getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取失效时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取荷载
     * @param token
     * @return
     */
    private Claims getClaimFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 根据荷载生成Token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 生成token失效时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration*1000);
    }
}
