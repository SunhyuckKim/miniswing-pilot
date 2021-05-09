package miniswing.pilot.web;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.service.ProdsService;
import miniswing.pilot.web.dto.ProdsResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProdsApiController {

    private final ProdsService prodsService;

    @GetMapping("/api/v1/prods/{prod_id}")
    public ProdsResponseDto findById (@PathVariable("prod_id") String id) {
        return prodsService.findById(id);
    }


}
