package com.example.hello.controller.crud;

import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

    @PutMapping(path = "put")
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto) {

        System.out.println(putRequestDto);

        return putRequestDto;  // 파라미터에서 요청한 putRequestDto값을  그대로 putRequestDto로 리턴한다.
    }

    @PutMapping(path = "path-variable/{userId}")
    public PutRequestDto pathVariable(@RequestBody PutRequestDto putRequestDto,
                                      @PathVariable(name = "userId") Long id) {

        System.out.println("id : " + id);

        return putRequestDto;
    }

    // GetMapping Controller에있는  @RequestMapping 방식처럼
    // PutMapping도 따로 실습해볼것
}
