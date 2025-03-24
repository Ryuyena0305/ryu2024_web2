package example.day10._멀티스레드;

/*[멀티스레드 문제] 스마트폰에서 멀티태스킹 구현하기.
   음악 기능: 음악을 실행하면 "음악 재생 중..."이 1초마다 출력됩니다.
   웹서핑 기능: 웹서핑을 실행하면 "웹서핑 중..."이 1초마다 출력됩니다.
   -> 실행중인 상태에서 해당 입력 번호가 들어오면 종료 합니다.
   사용자는 다음과 같은 명령을 입력할 수 있습니다.
   1을 입력하면 음악 기능을 ON/OFF 합니다.
   2를 입력하면 웹서핑 기능을 ON/OFF 합니다.
   0을 입력하면 프로그램을 종료합니다.
[실행 예]
   1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료
   >> 1
   음악 시작!
   음악 재생 중...
   음악 재생 중...
   >> 2
   웹서핑 시작!
   웹서핑 중...
   음악 재생 중...
   웹서핑 중...
   >> 1
   음악 종료!
   웹서핑 중...
   웹서핑 중...
   >> 2
   웹서핑 종료!
   >> 0
   스마트폰 종료...*/


import java.util.Scanner;

class music extends Thread{
    boolean state = false;
    @Override
    public void run(){
        int second = 0;
        try{
            while(state){
                Thread.sleep(1000);
                second++;
                System.out.println("음악 재생 중...");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class web extends Thread{
    boolean state1 = false;
    @Override
    public void run(){
        int second = 0;
        try{
            while(state1){
                Thread.sleep(1000);
                second++;
                System.out.println("웹서핑 중...");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
public class Example5 {
    public static void main(String[] args) {
        boolean state2 = true;
        music musicThread = new music();
        web webThread = new web();



        while(state2){
            System.out.println( "1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료\n>>");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            if( i == 1 ){
                if( musicThread.state == false ) {
                    System.out.println("음악 시작!");
                    musicThread.start();
                    musicThread.state = true;
                }
                else if( musicThread.state == true ){
                    System.out.println("음악 종료!");
                    musicThread.state = false;
                } // f
            }else if ( i == 2 ) {
                if( webThread.state1 == false ) {
                    System.out.println("웹서핑 시작!");
                    webThread.start();
                    webThread.state1 = true;
                }
                else if( webThread.state1 == true ){
                    System.out.println("웹서핑 종료!");
                    webThread.state1 = false;
                }
            }else if ( i == 0 ) {
                System.out.println("프로그램 종료!");
                musicThread.state = false;
                webThread.state1 = false;
                state2 = false;
            }
        }

    }


}
