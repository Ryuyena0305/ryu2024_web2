//package example.day08.controller;
//
//import example.day08.model.dto.ProductDto;
//import example.day08.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/day08/products")
//@CrossOrigin("http://192.168.40.32:5173")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    //전체조회
//    @GetMapping("")
//    public List<ProductDto> onRead(){
//        System.out.println("ProductController.onRead");
//        return productService.onRead();
//    }
//
//    //등록
//    @PostMapping("")
//    public int onCreate(@RequestBody ProductDto productDto){
//        System.out.println("ProductController.onSave");
//        return productService.onCreate(productDto);
//    }
//
//    //수정
//    @PutMapping("")
//    public int onUpdate(@RequestBody ProductDto productDto){
//        return productService.onUpdate(productDto);
//    }
//
//    //삭제
//    @DeleteMapping("")
//    public int onDelete(@RequestParam("id") int id){
//        return productService.onDelete(id);
//    }
//}
