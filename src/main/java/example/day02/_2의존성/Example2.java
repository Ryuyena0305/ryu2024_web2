package example.day02._2의존성;

/*
    스프링없이 싱글톤을 직접 생성하여 메소드를 사용한다
 */

class SampleService2{
    private static SampleService2 instance = new SampleService2();
    private SampleService2() {}
    public static SampleService2 getInstance(){
        return instance;
    }
    void method(){
        System.out.println("SampleService2.method()");
    }
}

//[2] 컨트롤러 클래스
class SampleController2 {
    SampleService2 sampleService2 = SampleService2.getInstance();
    public void method(){
        sampleService2.method();
    }
}
public class Example2 {
}
