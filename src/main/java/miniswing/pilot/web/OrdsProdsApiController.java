package miniswing.pilot.web;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.service.OrdsProdsService;
import miniswing.pilot.web.dto.OrdsProdsResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrdsProdsApiController {

    private final OrdsProdsService ordsProdsService;

    @GetMapping("/api/v1/ordsprods/{id}") //조회
    public OrdsProdsResponseDto findById (@PathVariable Long id) {
        return ordsProdsService.findById(id);
    }
}
