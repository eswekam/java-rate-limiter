package org.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ratelimiter.client.RateLimiterBuilder;
import org.example.ratelimiter.client.RateLimiterClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RateLimiterFilter implements Filter {
    private final RateLimiterClient rlClient;

    public RateLimiterFilter() {
        this.rlClient = new RateLimiterBuilder().service("service1").algorithm("sliding_window").build();
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String user = req.getHeader("Authorization");
        Boolean isRateLimited = !this.rlClient.shouldAccept(user, System.currentTimeMillis());
        if (isRateLimited) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(429);
            return;
        }

        chain.doFilter(request, response);
    }
}
