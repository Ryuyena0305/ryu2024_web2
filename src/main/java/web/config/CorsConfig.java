package web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //빈등록 //스프링 시잘될 때 해당 클래스를 읽어들임
public class CorsConfig implements WebMvcConfigurer {
    //(1) implements WebMvcConfigurer  : spring mvc 관련 설정값을 수정하는 인터페이스
    //(2) CORS 관련 설정값 수정 , 오버라이딩(재정의) , addCorsMappings 메소드
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//모든 스프링 컨트롤러의 HTTP주소 매핑 허용
                .allowedOrigins("http://localhost:5173", "http://localhost:5174")
                .allowedMethods("GET", "POST", "PUT", "DELETE") //허용할 HTTP 메소드들
               .allowedHeaders("*") // HTTP의 헤더 정보 적용
                .allowCredentials(true);
    }
    
}
