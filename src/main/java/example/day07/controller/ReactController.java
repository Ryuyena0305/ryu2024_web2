package example.day07.controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day07/react")
//@CrossOrigin("http://localhost:5173") //CROSS 정책 허용, 특정 URL만 허용 가능하도록

public class ReactController{
    
    //샘플데이터
    private List<Map<Object,String>> boards = new ArrayList<>();
    @PostMapping("")

    public boolean onPost(@RequestBody Map<Object,String> map){
        System.out.println("ReactController.onPost");
        System.out.println("map = " + map);
        boards.add(map);
        return true;
    }

    @GetMapping("")
    public List<Map<Object,String>>onFindAll(){
        System.out.println("ReactController.onFindAll");
        return boards;
    }
}