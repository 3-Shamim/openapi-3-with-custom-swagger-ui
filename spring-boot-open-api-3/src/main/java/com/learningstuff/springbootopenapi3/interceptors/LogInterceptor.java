package com.learningstuff.springbootopenapi3.interceptors;

import com.learningstuff.springbootopenapi3.dao.LogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১০/৩/২০
 * Time: ৯:১৬ AM
 * Email: mdshamim723@gmail.com
 */

@Slf4j
@AllArgsConstructor
@Component
public class LogInterceptor implements HandlerInterceptor {

    private final LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logService.logRequest(request);
        return true;
    }


}