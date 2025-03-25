package example.day11._스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//==================스프링 내장된 스레드풀을 커스텀/설정 클래스=========================//
@Configuration //Spring에서 설정 클래스 빈 등록
public class ThreadPoolConfig {
    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(10);
        executor.initialize();//스레드풀 초기화
        return executor;
    }
}
