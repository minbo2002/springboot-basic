package com.example.hello.controller.crud;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostApiController {

    @PostMapping(path = "post")  // PostMapping 방법 1) path 속성으로 명확하게 경로를 지정
    public void post(@RequestBody Map<String, Object> requestData) {  // post는 반환하지않으므로 void 사용
                                                         // json형태의 Key, Value로 받아야 하므로 Map 사용

        requestData.entrySet().forEach(stringObjectEntry -> {  //  .entrySet() : Map의 key, value 전체값 출력
        //  requestData.entrySet().forEach(stringObjectEntry ->  ==  requestData.forEach((key, value) ->

            System.out.println("key : " + stringObjectEntry.getKey());
            System.out.println("value : " + stringObjectEntry.getValue());
        });
    }

    // 위에 (@RequestBody Map<String, Object> requestData) 으로 받게되면 어떤값을 보낼지 미리 알아야하는데
    // key를 생성할때마다 추가하기가 애매하다.
    // 아래와 같이 dto로 형태로 mapping 할 수도 있다.
    // json key에 해당되는 이름과 dto내의 변수와 같아야한다.
    @PostMapping(path = "post-dto")  // PostMapping 방법 1) path 속성으로 명확하게 경로를 지정
    public void post(@RequestBody PostRequestDto postRequestDto) {  // post는 반환하지않으므로 void 사용

        System.out.println(postRequestDto);
    }


    // GetMapping Controller에있는  path-variable/{id} 및  @RequestMapping 방식처럼
    // PostMapping도 따로 실습해볼것

}
