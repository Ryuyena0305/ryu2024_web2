package example.day04Task.model.dto;

import lombok.*;

@Getter @Setter @ToString
@Builder @AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
