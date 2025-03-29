//package example.day08.model.mapper;
//
//import example.day08.model.dto.ProductDto;
//import org.apache.ibatis.annotations.*;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Mapper
//public interface ProductMapper {
//    @Select("select * from productsample")
//     List<ProductDto> onRead();
//
//    @Insert("insert into productsample (name, price, comment) values (#{name}, #{price}, #{comment})")
//    int onCreate(ProductDto productDto);
//
//
//    @Update("update productsample set price = #{price}, comment = #{comment} where id = #{id}")
//  int onUpdate(ProductDto productDto);
//
//    @Delete("delete from productsample where id = #{id}")
//    int onDelete( int id);
//
//}
