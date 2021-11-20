package com.moataz.miniproject.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwt = request.getHeader("Authorization");
        if (jwt ==null || !jwt.startsWith(SecParams.PREFIX)){
            filterChain.doFilter(request , response);
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods",
                    "GET,HEAD,OPTIONS,POST,PUT,DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept," +
                    " X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");

                    response.addHeader("Access-Control-Expose-Headers","Authorization, Access-Control- " +
                            "Allow-Origin,Access-Control-Allow-Credentials ");

            if (request.getMethod().equals("OPTIONS"))
            {
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }
        }
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecParams.SECRET)).build();

        jwt = jwt.substring(SecParams.PREFIX.length());

        DecodedJWT decodedJWT = verifier.verify(jwt);

        String username = decodedJWT.getSubject();

        List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for (String r : roles)
            authorities.add(new SimpleGrantedAuthority(r));

        UsernamePasswordAuthenticationToken user =
                new UsernamePasswordAuthenticationToken(username,null,authorities);

        SecurityContextHolder.getContext().setAuthentication(user);

        filterChain.doFilter(request,response);



    }
}
