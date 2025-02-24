package example.day04Task.service;

import example.day04Task.model.dto.BoardDto;
import example.day04Task.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;


    public int save( BoardDto boardDto){
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);
        return  boardMapper.save(boardDto);
    }

    public List<BoardDto> findAll(){
        return  boardMapper.findAll();
    }


    public BoardDto find( int bno){
        return  boardMapper.find(bno);
    }


    public int update( BoardDto boardDto){
        return  boardMapper.update(boardDto);
    }


    public int delete(int bno){
        return  boardMapper.delete(bno);
    }
}
