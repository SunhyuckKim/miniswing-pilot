package miniswing.pilot.web;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.service.OrdersService;
import miniswing.pilot.web.dto.OrdersResponseDto;
import miniswing.pilot.web.dto.OrdersSaveRequestDto;
import miniswing.pilot.web.dto.OrdersUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OrdersApiController {
    private final OrdersService ordersService;

    @PostMapping("/api/v1/orders") //저장
    public  Long save(@RequestBody OrdersSaveRequestDto requestDto) {

        return ordersService.save(requestDto);
    }

    @GetMapping("/api/v1/orders/{id}") //조회
    public OrdersResponseDto findById (@PathVariable Long id) {
        return ordersService.findById(id);
    }

    @PutMapping("/api/v1/orders/{id}") //업데이트
    public Long update(@PathVariable Long id, @RequestBody OrdersUpdateRequestDto requestDto) {
        return ordersService.update(id, requestDto);
    }
}
