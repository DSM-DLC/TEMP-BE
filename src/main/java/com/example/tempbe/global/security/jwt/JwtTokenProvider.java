package com.example.tempbe.global.security.jwt;

import com.example.tempbe.domain.admin.domain.types.Role;
import com.example.tempbe.global.exception.ExpiredTokenException;
import com.example.tempbe.global.exception.InvalidTokenException;
import com.example.tempbe.global.security.auth.AdminDetailsService;
import com.example.tempbe.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access_exp}")
    private Long accessExp;

    @Value("${jwt.refresh_exp}")
    private Long refreshExp;

    private static final String AUTHORIZATION_HEADER = "authorization";
    private static final String BEARER_PREFIX = "Bearer";

    private final AuthDetailsService authDetailsService;
    private final AdminDetailsService adminDetailsService;


    public String createAccessToken(String id, String role) {
        return Jwts.builder()
                .setSubject(id)
                .setHeaderParam("typ", "access")
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + accessExp * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public String createRefreshToken() {

        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + refreshExp * 1000))
                .setIssuedAt(new Date())
                .setHeaderParam("typ", "refresh")
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isRefreshToken(String token) {
            return "refresh".equals(getJws(token).getHeader().get("typ").toString());
    }

    public String getRole(String token) {
        return getJws(token).getBody().get("role").toString();
    }

    private Jws<Claims> getJws(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        }catch (ExpiredJwtException e){
            throw ExpiredTokenException.EXCEPTION;
        }catch (Exception e){
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public Authentication getAuthentication(String token){
        Claims body = getJws(token).getBody();

        UserDetails userDetails = getDetails(body);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader(AUTHORIZATION_HEADER);
        if(token != null && token.length() > 7 && token.startsWith(BEARER_PREFIX)){
            return token.substring(7);
        }
        return null;
    }

    private UserDetails getDetails(Claims body){
        if(Role.user.toString().equals(body.get("role").toString())) {
            return authDetailsService.loadUserByUsername(body.getSubject());
        }
        else {
            return adminDetailsService.loadUserByUsername(body.getSubject());
        }
    }
}