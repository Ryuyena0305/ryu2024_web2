package example.day04Task.controller;

import example.day04Task.model.dto.BoardDto;
import example.day04Task.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("day04/task/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public int save(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);
        return boardService.save(boardDto);
    }
    @GetMapping("")
    public List<BoardDto> findAll(){
        return boardService.findAll();
    }

    @GetMapping("view")
    public BoardDto find(@RequestParam("bno") int bno){
        return boardService.find(bno);
    }

    @PutMapping
    public int update(@RequestBody BoardDto boardDto){
        return boardService.update(boardDto);
    }

    @DeleteMapping
    public int delete(@RequestParam("bno")int bno){
        return boardService.delete(bno);
    }
}
