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

    @GetMapping("/api/v1/customers/{cust_num}") //조회
    public CustomersResponseDto findById (@PathVariable Long cust_num) {
        return customersService.findById(cust_num);
    }

    @PutMapping("/api/v1/customers/{cust_num}") //업데이트
    public Long update(@PathVariable Long cust_num, @RequestBody CustomersUpdateRequestDto requestDto) {
        return customersService.update(cust_num, requestDto);
    }
}
