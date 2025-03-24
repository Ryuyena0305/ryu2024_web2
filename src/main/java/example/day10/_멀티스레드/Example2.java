package example.day10._멀티스레드;

class 작업스레드A extends Thread{
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(1000);
                Thread.currentThread().setName("작업스레드A");//스레드 이름 정의/만들기 함수
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public class Example2 {
    //(1) main 스레드
    public static void main(String[] args) {
        //(2) 작업스레드 생성
    }
}
