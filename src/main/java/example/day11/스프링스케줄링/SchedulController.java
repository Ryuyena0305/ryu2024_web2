package example.day11._스프링스케줄링;

import example.day11.스프링스케줄링.SchedulService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day11/schedule")
@RequiredArgsConstructor
public class SchedulController {
    private final SchedulService schedulService;

    @GetMapping("/task3")
    public void task3() {
        schedulService.task3();
    }

}