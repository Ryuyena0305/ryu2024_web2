package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import web.model.dto.MemberDto;

@Mapper
public interface MemberMapper {
    @Insert("insert into member (mid,mpwd,mname,mimg) values(#{mid}, #{mpwd}, #{mname}, #{mimg})")
    public boolean signup(MemberDto memberDto);

}
