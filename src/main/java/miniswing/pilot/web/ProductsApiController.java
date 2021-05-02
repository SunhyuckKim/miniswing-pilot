package miniswing.pilot.web;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.service.ProductsService;
import miniswing.pilot.web.dto.ProductsResponseDto;
import miniswing.pilot.web.dto.ProductsSaveRequestDto;
import miniswing.pilot.web.dto.ProductsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class ProductsApiController {
    private final ProductsService productsService;

    @PostMapping("/api/v1/products") //저장
    public  Long save(@RequestBody ProductsSaveRequestDto requestDto) {

        return productsService.save(requestDto);
    }


    @GetMapping("/api/v1/products/{id}") //조회
    public ProductsResponseDto findById (@PathVariable Long id) {
        return productsService.findById(id);
    }

    @PutMapping("/api/v1/products/{id}") //업데이트
    public Long update(@PathVariable Long id, @RequestBody ProductsUpdateRequestDto requestDto) {
        return productsService.update(id, requestDto);
    }
}
