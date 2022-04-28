package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "get-mapping-path")  // GetMapping 방법 1) path 속성으로 명확하게 경로를 지정
    public String getHello() {

        return "GetMapping path";
    }

    // @RequestMapping은 get, post, put, delete 동작이 모두 mapping 가능하다.
    // GetMapping 방법 2) @RequestMapping 안에 method 속성으로 Get 동작 지정.
    @RequestMapping(value = "/get-request-mapping", method = RequestMethod.GET)
    public String hi() {

        return "RequestMapping Get";
    }

    @GetMapping(path = "path-variable/{id}")  //  localhost:8080/api/get/path-variable/{id}
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        // @GetMapping 내부의 { } 이름과  (@PathVariable(name = " ") 내부의  " " 이름이 같아야한다

        System.out.println("PathVariable : " + pathName);

        return pathName;
    }

    // 1) 파라미터 받는 방법 첫번째
    //  localhost:8080/api/get/query-param?name=김민보&email=minbo@naver.com
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {  //  .entrySet()  :  Map의 전체 key, value값을 출력
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 위에 (@RequestParam Map<String, String> queryParam) 으로 받게되면 어떤값을 보낼지 미리 알아야하는데
    // key를 생성할때마다 queryParam.get("name"); 이런식으로 추가해줘야하므로
    // 아래와 같이 명시적으로 변수로 받으면 된다.
    // 2) 파라미터 받는 방법 두번째
    @GetMapping(path = "query-param-2")
    public String queryParam2(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam int age) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // 명시적으로 변수로 받는다해도 갯수가 많아지면 불편하므로 dto로 형태로 mapping 할수도 있다.
    // 파라미터가 dto 객체로 들어오게되면 URL의 ? 뒤에 값들을 스프링부트에서 판단하고
    // json key에 해당되는 이름을 dto내의 변수와 매칭을 한다.
    // 3) 파라미터 받는 방법 세번째
    @GetMapping(path = "query-param-3")
    public String queryParam3(UserRequest userRequest) {

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }
}