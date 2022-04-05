package com.learningstuff.springbootopenapi3.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২১/৩/২০
 * Time: ২:৫৬ PM
 * Email: mdshamim723@gmail.com
 */

public interface LogService {

    public void logRequest(HttpServletRequest request);

    public void logRequestBody(HttpServletRequest request, Object requestBody);

    public void logResponse(HttpServletRequest request, HttpServletResponse response, Object responseBody);

}
