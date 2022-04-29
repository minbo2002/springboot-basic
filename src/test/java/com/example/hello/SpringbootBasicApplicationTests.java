package com.example.hello;

import com.example.hello.dto.ObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBasicApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        //  JsonProcessingException  :  writeValueAsString() 메서드에서 변환시킬때 예외가 발생할수 있으므로 예외처리해준다
        System.out.println("--------------------");

// Controller에서 JSON 방식의 Text로 request를 주면 --> ObjectMapper가 Getter method를 이용해서 --> Object로 바뀌고 --> method를 타게된다.
// response를 Object로 return 하게되면 --> ObjectMapper에 의해서 --> JSON 방식의 Text 로 바뀐다.
        var objectMapper = new ObjectMapper();


        // Object  -->  text
        var ObjectDto = new ObjectDto("kmb", 32, "010-1111-2222");
        var objectToText = objectMapper.writeValueAsString(ObjectDto);
        System.out.println("objectToText : " + objectToText);


        // text  -->  Object
        var textToObject = objectMapper.readValue(objectToText, ObjectDto.class);
        System.out.println("textToObject : " + textToObject);

    }



}
