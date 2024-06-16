package org.example.controllers;

import org.example.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hi")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> sayHello() {
        ResponseEntity<BaseResponse> resp = ResponseEntity.ok().body(new BaseResponse("Hello World"));
        return resp;
    }
}
