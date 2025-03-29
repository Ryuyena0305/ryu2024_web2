package example.day09Task.controller;

import example.day09Task.model.dto.ReviewDto;
import example.day09Task.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day09/review")
@CrossOrigin("http://localhost:5173")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 등록
    @PostMapping
    public boolean onCreate(@RequestBody ReviewDto reviewDto){
        return reviewService.onCreate(reviewDto);
    }


    // 특정 도서 리뷰 조회
    @GetMapping("")
    public List<ReviewDto> onView(@RequestParam int id){
        return reviewService.onView(id);
    }



    // 리뷰 삭제
    @DeleteMapping("")
    public boolean onDelete(@RequestParam int rid , String rpwd){
        return reviewService.onDelete(rid, rpwd);
    }


}