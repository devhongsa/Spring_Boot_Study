package com.example.hello.controller;

import com.example.hello.annotation.Timer;
import com.example.hello.dto.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //해당 Class는 REST API 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/get3/{name}")
    public String getapi(@PathVariable String name, @RequestParam String email){
        return name + " " + email;
    }

    @PostMapping("/post3")
    public User postapi(@Valid @RequestBody User user){
        return user;
    }

    @Timer
    @DeleteMapping("/delete2")
    public void delete() throws InterruptedException {
        Thread.sleep(2000);
    }

    //Text return
    @GetMapping("/hello") // http://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot!";
    }

    //Json return
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }

    //응답코드를 200말고 다른걸로 설정해주려면 ResponseEntity 객체로 리턴해야함.
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
