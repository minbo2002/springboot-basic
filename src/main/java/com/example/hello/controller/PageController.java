package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {

        return "main.html";
    }

    // ResponseEntity 방식
    @ResponseBody
    @GetMapping("/user")
    public UserDto user() {

        //  UserDto userDto = new UserDto();  ==  var userDto = new UserDto();
        var userDto = new UserDto();  // var 약어로 타입추론
        userDto.setName("kmb");
        userDto.setAddress("구로구");

        return userDto;
    }
}
