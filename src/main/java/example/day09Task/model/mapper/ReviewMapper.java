package example.day09Task.model.mapper;

import example.day09Task.model.dto.ReviewDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {
    // 리뷰 등록
    @Insert("insert into review(rcontent, id, rpwd) values(#{rcontent}, #{id}, #{rpwd})")
    public boolean onCreate(ReviewDto reviewDto);
    // 특정 도서 리뷰 전체 조회
    @Select("select * from review where id = #{id}")
    public abstract List<ReviewDto> onView(int bid);
    // 리뷰 삭제
    @Delete("delete from review where rid = #{rid} and rpwd = #{rpwd}")
    public boolean onDelete(int rid, String rpwd);


}