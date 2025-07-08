package com.yisimeans.interceptor;

import com.yisimeans.util.CurrentHolder;
import com.yisimeans.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * token攔截器類
 */

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.獲取請求路徑
        String uri = request.getRequestURI();
        log.info("請求路徑: {}", uri);

        // 2.獲取token
        String token = request.getHeader("token");

        // 3.檢查token是否為空，不為空則校驗token是否合法
        if (token != null && !token.isEmpty()) {
            try {
                Claims claims = JwtUtil.parseJwt(token);
                Integer employeeId = Integer.valueOf(claims.get("id").toString());
                CurrentHolder.setCurrentId(employeeId);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                log.info("令牌非法,返回401");
                return false;
            }
            log.info("令牌合法,放行請求");
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("令牌為空,返回401");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 刪除ThreadLocal中的員工ID
        CurrentHolder.remove();
        log.info("已清除ThreadLocal");
    }
}
