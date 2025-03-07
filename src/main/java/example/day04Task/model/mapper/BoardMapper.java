package example.day04Task.model.mapper;

import example.day04Task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("insert into day04board(title,content) values(#{title},#{content})")
    int save(BoardDto boardDto);

    @Select("select * from day04board")
    List<BoardDto> findAll();

    @Select("select * from day04board where bno = #{bno}")
    BoardDto find(int bno);

    @Update("update day04board set title = #{title}, content = #{content} where bno = #{bno}")
    int update(BoardDto boardDto);

    @Delete("delete from day04board where bno = #{bno}")
    int delete(int bno);
}
