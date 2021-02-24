package cn.edu.zucc.galiview.business.controller.admin;

import cn.edu.zucc.galiview.server.domain.Chapter;
import cn.edu.zucc.galiview.server.dto.ChapterDto;
import cn.edu.zucc.galiview.server.service.ChapterService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public List<ChapterDto> chapter() {
        return chapterService.list();
    }
}
