package example.day03._과제.model.dto;

import lombok.*;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Getter  @Setter
@ToString
@Builder
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
