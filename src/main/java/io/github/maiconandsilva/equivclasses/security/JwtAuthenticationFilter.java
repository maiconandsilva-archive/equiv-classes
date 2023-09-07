package io.github.maiconandsilva.equivclasses.security;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        ApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        Assert.notNull(ctx, "Context shouldn't be null");
        JwtUtils jwtUtils = ctx.getBean(JwtUtils.class);

        String authorization = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        try {
            if (authorization != null) {
                Authentication credentials = jwtUtils.parseToken(
                        authorization.replaceAll("Bearer ", ""));
                SecurityContextHolder.getContext().setAuthentication(credentials);
            }
            chain.doFilter(request, response);
        } catch(Throwable t) {
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
        }
    }
}
