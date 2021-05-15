package cn.edu.zucc.galiview.system.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

//    @Value("${system.test}")
//    private String systemTest;
//
//    @GetMapping("/list")
//    public ResponseDto list() {
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setContent(systemTest);
//        return responseDto;
//    }
}
