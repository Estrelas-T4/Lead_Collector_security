package br.com.zup.LeadCollector.config.security.JWT;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class FiltroDeAutorizacaoJWT extends BasicAuthenticationFilter {
    private JWTComponent jwtComponent;
    private UserDetailsService userDetailsService;

    public FiltroDeAutorizacaoJWT(AuthenticationManager authenticationManager,  JWTComponent jwtComponent,
                                  UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtComponent = jwtComponent;
        this.userDetailsService = userDetailsService;
    }
}
