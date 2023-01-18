package com.example.hello.service;

import com.example.hello.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public User hello(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<User> result2 = restTemplate.getForEntity(uri, User.class);

        System.out.println(result2.getStatusCode());
        System.out.println(result2.getBody());

        return result2.getBody();

    }
}
