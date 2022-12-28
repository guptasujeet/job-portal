package com.test.jobportal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomePageController {

    @ApiIgnore
    @GetMapping("/")
    public void redirectToSwaggerUI(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}
