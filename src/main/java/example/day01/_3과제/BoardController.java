package example.day01._3과제;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/day01/task/board")
public class BoardController {

    @PostMapping
    public boolean board(){
        return true;
    }

    @GetMapping
    public ArrayList<Map<String,String>> doGetBoard(){
        ArrayList<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("title","제목");
        map.put("bno","1");
        list.add(map);
        Map<String,String> map1 = new HashMap<>();
        map1.put("title","제목");
        map1.put("bno","2");
        list.add(map1);
        Map<String,String> map2 = new HashMap<>();
        map2.put("title","제목");
        map2.put("bno","3");
        list.add(map2);

    return list;
    }
    @GetMapping("/view")
    public Map<String,String> doGetBoardView(){
        Map<String,String> map = new HashMap<>();
        map.put("title","제목");
        map.put("bno","1");
        return map;
    }
    @PutMapping
    public boolean Board(){
        return true;
    }

    @DeleteMapping
    public int doDeleteBoard(){
        return 3;
    }

}
