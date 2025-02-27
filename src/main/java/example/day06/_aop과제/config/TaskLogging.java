package example.day06._aop과제.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect//AOP 적용
@Component //빈 등록
public class TaskLogging {

    //[*] @Before/@AfterReturning 사용하지 않고 @Around 하나로 표현

    @Around("execution (* example.day06._aop과제.service.TaskService.*(..))")
    public Object TaskServiceCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        // * 지정한 함수 시그니처 출력
        System.out.println("실행메소드 : " + joinPoint.getSignature());

        //1. 매개변수 출력
        System.out.println("매개변수 : " + joinPoint.getArgs()); // Arrays.toString(배열변수) : 배열 출력을 주소값이 아닌 값으로 반환
        // * 지정한 함수 실행
        Object result = joinPoint.proceed();
        // 반환 값 출력
        System.out.println("반환값 : "+result);
        return result;

    }

//        //[1] save,findAll 실행 전에, 앞에 * 모든 리턴 타입 , 뒤에 *:모든 메소드, (..) : 모든 매개변수 타입
//    @Before("execution(* example.day06._aop과제.service.StudentService.*(..))&&args(param)")
//    public void paramCheck(Object param){//다형성 모든 매개변수들 값을 대입받기 위해서
//        System.out.println("[TaskService exe]");
//        System.out.println("매개변수 : "+param);
//    }
//        //[2] save, findAll 실행 후
//    @AfterReturning(value = "execution(* example.day06._aop과제.service.StudentService.*(..))",returning = "result")
//    public void returnCheck(Object result){// 모든 값들을 Object 타입으로 저장할 수 있기 때문
//        System.out.println("[TaskService return]" );
//        System.out.println("반환값 : " + result);
//    }
//
//
//
//        //[3] save, find 실행전과 실행 후 걸린 시간
//
//        @Around("execution( * example.day06._aop과제.service.StudentService.*(..))")
//        public Object timeCheck5(ProceedingJoinPoint joinPoint) throws Throwable {
//            //ProceedingJoinPoint : 지정한 메소드와 추가적인 로직과 조합해서 구현
//            // --> 추가로직에서 직접 지정한 메소드 호출  : joinPoint.proceed();
//
//            //제공하는 메소드
//            //1. .proceed() : 지정한 메소드를 실행하는 메소드
//            System.out.println(joinPoint.getArgs()); // 지정한 메소드의 매개변수반환 (배열타입)
//            System.out.println(joinPoint.getSignature()); //지정한 메소드 시그니처 (실행된 메소드의 리턴타입, 함수명,매개변수)
//            System.out.println(joinPoint.getTarget());
//            System.out.println(joinPoint.getThis());
//
//            //(1) 시작 시간
//            long startTime = System.currentTimeMillis();// System.currentTimeMillis() : 현재 시간을 밀리초(1/1000초) 반환
//
//            //(*) //지정된 메소드('enter3') 실행
//            Object result = joinPoint.proceed(); //지정된 메소드('enter3') 실행
//            //(2) 끝나는 시간
//            long endTime = System.currentTimeMillis();// 현재 시간을 밀리초(1/1000초) 반환
//
//            //(3) 지정된 메소드가 실행했을 때 걸린시간 계산
//            long timeMs = endTime - startTime;
//            //(4) 메소드 실행시간
//            System.out.println("메소드가 실행된 시간 : " + timeMs + "ms");
//            return result; // result 리턴
//        }

}
