package com.carlos.estudos.plataforma.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtProvider {

    @Value("${app.secret_key}")
    private String secretKey;

    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                    .setIssuedAt(new Date())
                    .setSubject(user.getUsername())
                    .signWith(getSigningKey())
                    .compact();
    }


    private Key getSigningKey(){

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        return new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }

}
