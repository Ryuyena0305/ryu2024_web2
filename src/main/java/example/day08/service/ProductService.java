//package example.day08.service;
//
//import example.day08.model.dto.ProductDto;
//import example.day08.model.mapper.ProductMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductMapper productMapper;
//
//
//    public List<ProductDto> onRead(){
//
//        return productMapper.onRead();
//    }
//
//
//    public int onCreate(ProductDto productDto){
//        System.out.println("ProductService.onSave");
//        System.out.println("productDto = " + productDto);
//        return productMapper.onCreate(productDto);
//    }
//
//
//    public int onUpdate(ProductDto productDto){
//        System.out.println("ProductController.onUpdate");
//        return productMapper.onUpdate(productDto);
//    }
//
//    public int onDelete( int id){
//        System.out.println("ProductController.onDelete");
//        return productMapper.onDelete(id);
//    }
//
//}
