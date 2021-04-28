package miniswing.pilot.web;

import miniswing.pilot.web.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @GetMapping("/miniswing")
    public String miniswing() {
        return "miniswing";
    }

    @GetMapping("/miniswing/dto")
    public ResponseDto helloDto(@RequestParam("name") String name,
                           @RequestParam("number") int number) {
        return new ResponseDto(name, number);
    }
}
