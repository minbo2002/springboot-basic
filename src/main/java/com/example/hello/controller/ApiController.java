package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // REST API를 처리하는 Controller (@Controller + @ResponseBody)
@RequestMapping("/api")
public class ApiController {

    // TEXT 방식
    @GetMapping("/text")
    public String text(@RequestParam String account) {

        return account;
    }

    // JSON 방식
    // request가 오면  -->  Object Mapper에 의해서  -->  object로 바뀐 다음 --> method를 타게된다.
    // object를 던지면 -->  Object Mapper에 의해서  -->  json으로 바뀐 다음  --> response가 내려간다.
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto userDto) {

        return userDto;
    }

    // ResponseEntity 방식
    @PutMapping("/put")
    public ResponseEntity<UserDto> put(@RequestBody UserDto userDto) {
        // response를 내려줄때 HttpStatus(1xx, 2xx, 3xx, 4xx, 5xx 등등)를 정해줄것이다

        // ResponseEntity.ok(userDto);   // .ok() : 직접 Body를 넣어줄수있다.
        //                                         이때 Body는 ObjectMapper에 의해서 JSON으로 바뀌고 response가 내려간다
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
        // .status( ).body( ) 메서드  :  Http Status 직접 지정하고 Body를 넣어줄수있다.
        //                              이때 Body는 ObjectMapper에 의해서 JSON으로 바뀌고 response가 내려간다
        //  HttpStatus.CREATED  :  HttpStatus 201
    }

}
