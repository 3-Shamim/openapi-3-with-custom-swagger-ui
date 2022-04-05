package com.learningstuff.springbootopenapi3.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৪/২/২২
 * Time: ১০:৫১ AM
 * Email: mdshamim723@gmail.com
 */

@RestController
@RequestMapping(value = "")
public class BasicController {

    @SecurityRequirement(name = "basic-security")
    @GetMapping(value = "/basic")
    public String basic() {
        return "Basic Security";
    }

    @SecurityRequirement(name = "bearer-security")
    @GetMapping(value = "/bearer")
    public String bearer() {
        return "Bearer Security";
    }

    @SecurityRequirement(name = "api-key")
    @GetMapping(value = "/api-key")
    public String apiKey() {
        return "Api Key Security";
    }

    @SecurityRequirement(name = "x-token")
    @GetMapping(value = "/x-token")
    public String xToken() {
        return "X-Token Security";
    }

}
