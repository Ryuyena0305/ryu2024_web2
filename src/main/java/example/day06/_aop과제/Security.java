package example.day06._aop과제;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
class Security {
    @Before("execution( * day06._aop과제.StudentService.*(..) )")
    // 지정한 메소드가 실행되기 전에 아래 메소드가 실행 된다.
    // 지정한 메소드는 'TestService2' 클래스의 *(모든메소드) 이면서 (..)모든매개변수타입 *(모든리턴타입)
    // 즉] 'TestService2' 모든 메소드들은 실행되기전에 'securityCheck()'메소드가 자동으로 실행된다.
    public void securityCheck() {
        System.out.println("메소드 실행 전(before) : 서비스 시작");
    } // f end

//    @After("execution( * example.day06._aop과제.Service2.save(..)&& * example.day06._aop과제.Service2.findAll(..))")
//    public void securityCheck2() {
//        System.out.println("메소드 실행 후(after) : 서비스 종료 ");
//    }

    //[3]
    @Before("execution( * example.day06._aop과제.service.StudentService.save(..))&& args(map)")
    public void securityCheck1(Object map) {
        System.out.println("메소드 실행 전(before) :" +map+"");
    }//f e
    @Before("execution( * example.day06._aop과제.StudentService.findAll(..))&& args(map)")
    public void securityCheck2(Object map) {
        System.out.println("메소드 실행 전(before) :" +map+"");
    }//f e

    // [4]
    @AfterReturning(value = "execution( * example.day06._aop과제.StudentService.save(..))",
            returning = "result")
    // 지정한 메소드가 정상적으로 실행 되었을때 result 리턴값을 가지고 와서 아래 메소드에서 사용이 가능하다.
    public void securityCheck3(Object result) {
        System.out.println("메소드 실행 후(after) : " + result + " 이/가 결과값  정상 ");
    }
    @AfterReturning(value = "execution( * example.day06._aop과제.StudentService.findAll(..))",
            returning = "result")
    // 지정한 메소드가 정상적으로 실행 되었을때 result 리턴값을 가지고 와서 아래 메소드에서 사용이 가능하다.
    public void securityCheck4(Object result) {
        System.out.println("메소드 실행 후(after) : " + result + " 이/가 결과값  정상 ");
    }


} // class end