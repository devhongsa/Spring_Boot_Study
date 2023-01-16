package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        return "get Hello";
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        return name;
    }

    // query parameter 변수를 정해주지않고, 아무 파라미터나 다 들어오게함.
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // query parameter 변수를 처음부터 정해줌.
    // 이렇게하면 변수가 늘어날수록 계속 추가해줘야되는 불편함이 있음. 이를 위해 실무에선 DTO를 사용함
    @GetMapping("query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        return name + " " + email + " " + age;
    }

    //DTO를 활용한 버전
    @GetMapping("query-param3")
    public String queryParam3(UserRequest userRequest){
        return userRequest.toString();
    }
}
