package example.day06.aop;

class TestService{
    public void enter1(){
        System.out.println("[코로나]온도 체크");
        System.out.println("식당 입장");
    }

    public void enter2(){
        System.out.println("[코로나]온도 체크");
        System.out.println("학원 입장");
    }
}

public class Example1 {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.enter1();
        testService.enter2();
    }
}
