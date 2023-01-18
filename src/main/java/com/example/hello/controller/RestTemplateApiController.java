package com.example.hello.controller;

import com.example.hello.dto.User;
import com.example.hello.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class RestTemplateApiController {

    private final RestTemplateService restTemplateService;

    //여기에는 Autowired가 생략되어 있음.
    public RestTemplateApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public User getHello(){
        return restTemplateService.hello();
    }

}
