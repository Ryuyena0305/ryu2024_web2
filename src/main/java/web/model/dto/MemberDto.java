package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

@Data //@Getter @Setter @ToString 등등 포함
@AllArgsConstructor
@NoArgsConstructor
@Builder //빌더 패턴
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mimg;

}
