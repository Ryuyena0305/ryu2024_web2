package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Annotation2{
    //(1) interface 타입 앞에 @ 붙인다
    //(2) 어노테이션 명을 임의로 지정한다.
    //(3) 어노테이션 명 위에 ㅔ@Retention(RetentionPolicy.RUNTIME) 리플렉션 설정한다.
    //(4) 어노테이션 명 위에 @TargetType(ElementType.적용할대상) 정용할 대상 설정한다.
    String value1();
    int value2() default 100; //(6) ��버변수의 기본값을 정할 수 있다.
}
class  TestClass2{
    //[2] 지정한 코드에 어노테이션 주입하기
    @Annotation2(value1="유재석" , value2=40)
    public void method1() {}//해당함수 안에서 value1,value2 사용 가능

    @Annotation2(value1="강호동")
    public void method2() {}//해당함수 안에서 value1, value2 사용 가능
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Annotation3{
    String value1();
    int value2() default 100;
}
@Annotation3(value1="유재석",value2 = 40)
class Member{}

public class Example2{
    public static void main(String[] args) {
        Annotation3 annotation3 = Member.class.getAnnotation(Annotation3.class); // "유재석"
        System.out.println(annotation3.value1()); // "유재석"
        System.out.println(annotation3.value2()); // 40
    }
}