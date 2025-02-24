package example.day04._실습.model.dto;

import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter @Setter @SpringBootApplication
@NoArgsConstructor @ToString
public class StudentDto {
    private int sno;
    private String name;
    private int kor;
    private int math;
}
