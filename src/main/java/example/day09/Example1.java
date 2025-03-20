package example.day09;

class MemberDto{
    private String name;
    private int age;

    public MemberDto (String name, int age){
        this.name = name;
        this.age = age;
    }

}


public class Example1 {
    public static void main(String[] args) {
        //(1) MemberDto(객체) 생성할 때 멤버변수 초기(사용) 값을 대입하는 방법(생성자)
        MemberDto memberDto0 = new MemberDto("유재석",40);
        //MemberDto memberDto1 = new MemberDto(); //기본생성자가 존재하지않음
        //MemberDto memberDto2 = new MemberDto("유재석");//정의된 생성자가 없어서

        //생성자 규칙 :
        //1. 정의된 생성자만 사용이 가능하다, 만든 생성자가 1개도 없을 때는 기본생성자가 자동으로 생성된다.
        //2. 매개변수 순서와 타입 , 개수 일치해야한다.

        //다양한 생성자를 사용하면 복잡도 올라간다 -> Builder Pattern
        //!빌더 패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
    }
}
