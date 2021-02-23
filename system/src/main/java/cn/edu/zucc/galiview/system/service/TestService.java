package cn.edu.zucc.galiview.system.service;

import cn.edu.zucc.galiview.system.domain.Test;
import cn.edu.zucc.galiview.system.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }
}
