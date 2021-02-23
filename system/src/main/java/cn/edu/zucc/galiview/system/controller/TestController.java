package cn.edu.zucc.galiview.system.controller;

import cn.edu.zucc.galiview.server.domain.Test;
import cn.edu.zucc.galiview.server.service.TestService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@ComponentScan("cn.edu.zucc.galiview")
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public List<Test> test() {
        return testService.list();
    }
}
