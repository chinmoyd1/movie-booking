package com.varNcrement.bookingservice.commons.security.filter;

import com.varNcrement.bookingservice.commons.security.util.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenFilter.class);

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        log.debug("Inside JWT Token filter.");
        HttpServletResponse response = (HttpServletResponse) res;
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;

                log.debug("Authenticating filter...");
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\n\"message\": \""+e.getMessage()+"\"\n}");
        }
        filterChain.doFilter(req, res);
    }
}

