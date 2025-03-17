package example.day09Task.model.dto;

import lombok.*;

@Getter @Setter
@ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;
    private String writer;
    private String name;
    private String comment;
    private int pwd;
}
