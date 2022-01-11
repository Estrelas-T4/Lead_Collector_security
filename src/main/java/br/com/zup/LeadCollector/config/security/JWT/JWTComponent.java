package br.com.zup.LeadCollector.config.security.JWT;

import br.com.zup.LeadCollector.config.security.JWT.exceptions.TokenInvalidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTComponent {
    @Value("${jwt.segredo}")
    private String segredo;
    @Value("${jwt.milissegundos}")
    private Long milissegundo;

    public String gerarToken(String username, String id){
        Date vencimento = new Date(System.currentTimeMillis()+milissegundo);

        String token = Jwts.builder().setSubject(username)
                .claim("idUsuario", id).setExpiration(vencimento).claim("aleatorio", "xablau")
                .signWith(SignatureAlgorithm.HS512, segredo.getBytes()).compact();

        return token;
    }

    public Claims pegarClaims(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(segredo.getBytes()).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            throw new TokenInvalidoException();
        }
    }

    public boolean tokenValido(String token){
        try{
            Claims claims = pegarClaims(token);
            Date dataAtual = new Date(System.currentTimeMillis());

            String username = claims.getSubject();
            Date vencimentoToken = claims.getExpiration();

            if(username != null && vencimentoToken != null && dataAtual.before(vencimentoToken)){
                return true;
            }else {
                return false;
            }
        }catch (TokenInvalidoException e){
            return false;
        }
    }

}
