package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    @RequestMapping("/add")
    public Addition addition(@RequestParam(value="num1", defaultValue="5") int num1, @RequestParam(value="num2", defaultValue="5") int num2) {
        return new Addition(num1, num2);
    }
}