package example.day11.스케줄링과제;

import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TaskMapper {

    @Update("UPDATE day11products SET stock_quantity = stock_quantity - 3")
    int reduce();

    @Select("SELECT * FROM day11products")
    List<HashMap<String,String>> view();

    @Update("UPDATE day11products SET stock_quantity = stock_quantity + 20 WHERE stock_quantity <= 10")
    int increase();
}
