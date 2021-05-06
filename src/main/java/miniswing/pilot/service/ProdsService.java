package miniswing.pilot.service;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.domain.Prods;
import miniswing.pilot.domain.ProdsRepository;
import miniswing.pilot.web.dto.ProdsResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class ProdsService {

    private final ProdsRepository prodsRepository;

    //상품정보조회
    public ProdsResponseDto findById(String prod_id) {
        Prods entity = prodsRepository.findById(prod_id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + prod_id));

        return new ProdsResponseDto(entity);
    }
}
