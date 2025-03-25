package example.day11.스케줄링과제;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private int productId;
    private String productName;
    private int stockQuantity;
}
