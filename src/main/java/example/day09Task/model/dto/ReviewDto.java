package example.day09Task.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private int rid;
    private String rcontent;
    private String rpwd;
    private int id;
}