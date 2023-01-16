package com.example.hello.controller;

import com.example.hello.dto.PostRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String,Object> requestData){
        requestData.forEach((key,value)->{
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    //DTO 사용
    @PostMapping("/post2")
    public void post2(@RequestBody PostRequest postRequest){
       System.out.println(postRequest.toString());
    }
}
