package com.learningstuff.springbootopenapi3.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Email: mdshamim723@gmail.com
 * Date: ১৭/৩/২২
 * Time: ৫:১৫ PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class JwtFilterRequest extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        log.info("Bearer token authentication processing for {}", request.getRequestURL());

        String header = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(header) && header.startsWith("Bearer ")) {

            String token = header.replace("Bearer ", "");

            // Once we get the token validate it.
            if (SecurityContextHolder.getContext().getAuthentication() == null && StringUtils.isNotEmpty(token)) {

                log.info("Try to authenticate with bearer token.");

                // if token is valid configure Spring Security to manually set
                // authentication
                if (token.equals("123")) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            new HashMap<>() {{
                                put("username", "Shamim");
                            }},
                            null,
                            new ArrayList<>()
                    );

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // After setting the Authentication in the context, we specify
                    // that the current user is authenticated. So it passes the
                    // Spring Security Configurations successfully.
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                    log.info("Successfully authenticate with bearer token.");

                }
            }

        }


        chain.doFilter(request, response);
    }

}
