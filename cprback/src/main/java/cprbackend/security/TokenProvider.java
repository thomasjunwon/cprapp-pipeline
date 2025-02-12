package cprbackend.security;

import cprbackend.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider{
    private static final String SECRET_KEY="NMA8JPctFuna59f5POKF34T9E8RSHFP9348utper9ijpuna59f5NMA85";

    public String create(Member member){
        Date expiryDate=Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        String token = Jwts.builder()
                .claim("sub", member.getUserId())
                .claim("iss", "cpr app")
                .claim("iat", new Date())
                .claim("exp", expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return token;
    }

    public String validateToken(String token){
        Claims payload = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return payload.getSubject();
    }
}
