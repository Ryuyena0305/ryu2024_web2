package example.day02._2의존성;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* IOC와 DI */
//[1] 서비스 클래스

    //bean : 스프링 컨테이너(메모리)에서 관리하는 인스턴스/객체, IOC
    //IOC(제어의 역전) :  개발자가 인스턴스(new) 생성하지 않고 스프링 대신 인스턴스 생성/관리 한다.
    @Component // 1. 스프링 컨테이너(메모리)에 빈(인스턴스) 등록
class SampleService3 {

    void method(){
        System.out.println("SampleService3.method()");
    }

}
//[2] 컨트롤러 클래스
class SampleController3 {
    @Autowired //2. 스프링 컨테이너(메모리)에 등록된 빈(인스턴스) 주입한다. DI : DI(Dependency Injection)의존성 주입
    private SampleService3 sampleService3;
    public void method(){
        sampleService3.method();

    }


}

public class Example3 {

}
