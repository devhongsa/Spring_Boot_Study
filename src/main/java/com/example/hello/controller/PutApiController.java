package com.example.hello.controller;

import com.example.hello.dto.PutRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequest put(@RequestBody PutRequest putRequest, @PathVariable Long userId){
        System.out.println(userId);

        // Dto 객체를 그대로 리턴하면 SpringBoot에서 알아서 Json형태로 바꿔서 response해줌.(Object Mapper)
        // 단 Dto Class에는 get method, default 생성자가 있어야한다.
        return putRequest;
    }
}
