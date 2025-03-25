package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class ThreadService {
    @Async //비동기
    public void thread1(){
        String name = UUID.randomUUID().toString();
        for(int i = 1;i<=10;i++){
            System.out.println(i+"작업스레드 : "+name);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    @Async //동기
    public synchronized void thread2(){
        String name = UUID.randomUUID().toString();
        for(int i = 1;i<=10;i++){
            System.out.println(i+"작업스레드 : "+name);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
