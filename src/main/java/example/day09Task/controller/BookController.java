package example.day09Task.controller;


import example.day09Task.model.dto.BookDto;
import example.day09Task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day09/books")
@CrossOrigin("http://192.168.40.32:5173")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("")
    public int onPost(@RequestBody BookDto bookDto){
        System.out.println("BookController.onPost");
        return bookService.onPost(bookDto);
    }

    @GetMapping("")
    public List<BookDto> onGet(){
        System.out.println("BookController.onRead");
        return bookService.onGet();
    }
    @GetMapping("/byid")
    public BookDto onGetbyid(@RequestParam("id") int id){
        System.out.println("BookController.onRead");
        return bookService.onGetbyid(id);
    }

    @PutMapping("")
    public int onUpdate(@RequestBody BookDto bookDto){
        System.out.println("BookController.onUpdate");
        return bookService.onUpdate(bookDto);
    }

    @DeleteMapping("")
    public int onDelete(@RequestParam("id") int id) {
        return bookService.onDelete(id);
    }

}
