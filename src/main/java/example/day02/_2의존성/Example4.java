package example.day02._2의존성;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*  IOC 와 DI **권장방법!! */
@Service//@Service에는 @Component 포함
class SampleService4 {
    void method(){
        System.out.println("SampleService4.method()");
    }

}//c e

class SampleController4 {
    //static : 전역 키워드 , final : 수정불가키워드
private final SampleService4 sampleService4;
@Autowired
public SampleController4(SampleService4 sampleService4) {
    this.sampleService4 = sampleService4;
}

}
public class Example4 {
}
