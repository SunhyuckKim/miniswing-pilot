package miniswing.pilot.web;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.service.CustomersService;
import miniswing.pilot.web.dto.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CustomersApiController {

    private final CustomersService customersService;

    @PostMapping("/api/v1/customers") //저장
    public  Long save(@RequestBody CustomersSaveRequestDto requestDto) {

        return customersService.save(requestDto);
    }

    @GetMapping("/api/v1/customers/{id}") //조회
    public CustomersResponseDto findById (@PathVariable Long id) {
        return customersService.findById(id);
    }

    @PutMapping("/api/v1/customers/{id}") //업데이트
    public Long update(@PathVariable Long id, @RequestBody CustomersUpdateRequestDto requestDto) {
        return customersService.update(id, requestDto);
    }
}
