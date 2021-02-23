package cn.edu.zucc.galiview.server.service;

import cn.edu.zucc.galiview.server.domain.Test;
import cn.edu.zucc.galiview.server.domain.TestExample;
import cn.edu.zucc.galiview.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo("1");
        testExample.setOrderByClause("id desc");
        return testMapper.selectByExample(testExample);
    }
}
