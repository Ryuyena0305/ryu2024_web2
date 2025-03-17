package example.day09Task.service;

import example.day09Task.model.dto.BookDto;
import example.day09Task.model.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;


    public int onPost( BookDto bookDto){
        System.out.println("ProductController.onSave");
        System.out.println("bookDto = " + bookDto);
        return bookMapper.onPost(bookDto);
    }


    public List<BookDto> onGet(){
        System.out.println("BookController.onRead");
        System.out.println("bookMapper = " + bookMapper);
        return bookMapper.onGet();
    }


    public BookDto onGetbyid(int id){
        System.out.println("BookController.onRead");
        return bookMapper.onGetbyid(id);
    }

    public int onUpdate(BookDto bookDto){
        System.out.println("BookController.onUpdate");
        return bookMapper.onUpdate(bookDto);
    }

    public int onDelete( int id){
        System.out.println("BookController.onDelete");
        return bookMapper.onDelete(id);
    }
}
