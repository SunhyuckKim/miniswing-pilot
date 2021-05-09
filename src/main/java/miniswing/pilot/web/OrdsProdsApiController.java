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

    @GetMapping("/api/v1/ordsprods/{svc_mgmt_num}") //조회
    public OrdsProdsResponseDto findById (@PathVariable("svc_mgmt_num") long svc_mgmt_num) {
        return ordsProdsService.findById(svc_mgmt_num);
    }
}
