package com.delta.soft_manage_system.common;

import com.alibaba.fastjson.JSON;
import com.delta.soft_manage_system.dto.User;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * 管理所有的Token
 * @author lizong.wei
 *
 */
public class TokenMgr {
	
	public static SecretKey generalKey() {
		try {
			//方式一：byte[] encodedKey = Base64.decode(Constant.JWT_SECERT); 引入com.sun.org.apache.xerces.internal.impl.dv.util.Base64
			//方式二：不管哪种方式最终得到一个byte[]类型的key就行
			byte[] encodedKey = JWTConstant.JWT_SECERT.getBytes("UTF-8");
		    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		    return key;
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}
	/**
	 * 签发JWT
	 * @param id  jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
	 * @param iss jwt签发者
	 * @param subject jwt所面向的用户
	 * @param ttlMillis 有效期,单位毫秒
	 * @return token
	 * @throws Exception
	 */
	public static String createJWT(String id,String iss, String subject, long ttlMillis) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey secretKey = generalKey();
		JwtBuilder builder = Jwts.builder()
				.setId(id)
				.setIssuer(iss)
				.setSubject(subject)
				.setIssuedAt(now)
				.signWith(signatureAlgorithm, secretKey);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date expDate = new Date(expMillis);
			builder.setExpiration(expDate);
		}
		return builder.compact();
	}
	
	/**
	 * 验证JWT
	 * @param jwtStr
	 * @return
	 */
	public static ServerResponse<Claims> validateJWT(String jwtStr) {
		ServerResponse<Claims> serverResponse = ServerResponse.createBySuccess();
		Claims claims = null;
		try {
			claims = parseJWT(jwtStr);
			serverResponse = ServerResponse.createBySuccess(claims);
		} catch (ExpiredJwtException e) {
			serverResponse = ServerResponse
					.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_EXPIRE,"token expired");
		} catch (SignatureException e) {
			serverResponse = ServerResponse
					.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_FAIL,"token fault");
		} catch (Exception e) {
			serverResponse = ServerResponse
					.createByErrorCodeMessage(JWTConstant.JWT_ERRCODE_FAIL,"server fault");
		}
		return serverResponse;
	}
	
	/**
	 * 
	 * 解析JWT字符串
	 * @param jwt
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

	/**
	 *
	 * 設置JWT字符串過期
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static void expiredJWT(String jwt) {
		SecretKey secretKey = generalKey();
		Claims claims = Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(jwt)
				.getBody();
		claims.setExpiration(new Date(System.currentTimeMillis() - 360000));

	}
	
	/**
	 * 生成subject信息
	 * @param sub
	 * @return
	 */
	public static String generalSubject(User sub){
		return JSON.toJSONString(sub);
	}
}