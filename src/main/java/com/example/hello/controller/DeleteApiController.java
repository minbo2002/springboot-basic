package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteApiController {

    @DeleteMapping(path = "delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {

        System.out.println(userId);
        System.out.println(account);

        // delete는 Resource가 없는상태라도 Http응답상태 200을 출력한다

        // GetMapping Controller에있는  @RequestMapping 방식처럼
        // PutMapping도 따로 실습해볼것
    }
}
