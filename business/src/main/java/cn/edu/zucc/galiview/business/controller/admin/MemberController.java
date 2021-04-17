package cn.edu.zucc.galiview.business.controller.admin;

import cn.edu.zucc.galiview.server.dto.MemberDto;
import cn.edu.zucc.galiview.server.dto.PageDto;
import cn.edu.zucc.galiview.server.dto.ResponseDto;
import cn.edu.zucc.galiview.server.exception.BusinessException;
import cn.edu.zucc.galiview.server.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/member")
public class MemberController {

    private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
    public static final String BUSINESS_NAME = "会员";

    @Resource
    private MemberService memberService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        memberService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 校验手机号是否存在
     * 存在则success=true，不存在则success=false
     */
    @GetMapping(value = "/is-mobile-exist/{mobile}")
    public ResponseDto isMobileExist(@PathVariable(value = "mobile") String mobile) throws BusinessException {
        LOG.info("查询手机号是否存在开始");
        ResponseDto responseDto = new ResponseDto();
        MemberDto memberDto = memberService.findByMobile(mobile);
        if (memberDto == null) {
            responseDto.setSuccess(false);
        } else {
            responseDto.setSuccess(true);
        }
        return responseDto;
    }
}
