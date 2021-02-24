package cn.edu.zucc.galiview.business.controller;

import cn.edu.zucc.galiview.server.domain.Chapter;
import cn.edu.zucc.galiview.server.service.ChapterService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/chapter")
    public List<Chapter> chapter() {
        return chapterService.list();
    }
}
