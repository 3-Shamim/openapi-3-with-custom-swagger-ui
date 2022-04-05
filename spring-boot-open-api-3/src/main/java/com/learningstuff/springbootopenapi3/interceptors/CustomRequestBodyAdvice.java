package com.learningstuff.springbootopenapi3.interceptors;

import com.learningstuff.springbootopenapi3.dao.LogService;
import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২১/৩/২০
 * Time: ২:৪৯ PM
 * Email: mdshamim723@gmail.com
 */

@ControllerAdvice
@AllArgsConstructor
public class CustomRequestBodyAdvice extends RequestBodyAdviceAdapter {

    private final LogService logService;
    private final HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        logService.logRequestBody(httpServletRequest, body);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}