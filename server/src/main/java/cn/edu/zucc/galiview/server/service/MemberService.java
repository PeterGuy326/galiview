package cn.edu.zucc.galiview.server.service;

import cn.edu.zucc.galiview.server.domain.Member;
import cn.edu.zucc.galiview.server.domain.MemberExample;
import cn.edu.zucc.galiview.server.dto.MemberDto;
import cn.edu.zucc.galiview.server.dto.PageDto;
import cn.edu.zucc.galiview.server.mapper.MemberMapper;
import cn.edu.zucc.galiview.server.util.CopyUtil;
import cn.edu.zucc.galiview.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
        import java.util.Date;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    /**
    * 列表查询
    */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        MemberExample memberExample = new MemberExample();
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        PageInfo<Member> pageInfo = new PageInfo<>(memberList);
        pageDto.setTotal(pageInfo.getTotal());
        List<MemberDto> memberDtoList = CopyUtil.copyList(memberList, MemberDto.class);
        pageDto.setList(memberDtoList);
    }

    /**
    * 保存，id有值时更新，无值时新增
    */
    public void save(MemberDto memberDto) {
        Member member = CopyUtil.copy(memberDto, Member.class);
        if (StringUtils.isEmpty(memberDto.getId())) {
        this.insert(member);
    } else {
        this.update(member);
        }
    }

    /**
    * 新增
    */
    private void insert(Member member) {
        Date now = new Date();
        member.setId(UuidUtil.getShortUuid());
        member.setRegisterTime(now);
        memberMapper.insert(member);
    }

    /**
    * 更新
    */
    private void update(Member member) {
        memberMapper.updateByPrimaryKey(member);
    }

    /**
    * 删除
    */
    public void delete(String id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}