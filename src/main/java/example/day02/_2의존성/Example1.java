package example.day02._2의존성;

//[1] 서비스 클래스
class SampleService1 {

    void method(){
        System.out.println("SampleService1.method()");
    }
}
//[2] 컨트롤러 클래스
class SampleController1 {

    SampleService1 sampleService1 = new SampleService1();
    public void method(){
        sampleService1.method(); //서비스클래스의 메소드 호출
    }
}

public class Example1 {
    //스프링 없이 객체를 직접 생성하여 메소드를 사용한다
    //단점:

}
