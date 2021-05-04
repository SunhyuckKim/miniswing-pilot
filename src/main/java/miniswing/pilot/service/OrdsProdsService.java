package miniswing.pilot.service;


import lombok.RequiredArgsConstructor;
import miniswing.pilot.domain.OrdsProds;
import miniswing.pilot.domain.OrdsProdsRepository;
import miniswing.pilot.web.dto.OrdsProdsResponseDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class OrdsProdsService {

    private final OrdsProdsRepository ordsProdsRepository;

    //고객정보 조회
    public OrdsProdsResponseDto findById(Long id) {
        OrdsProds entity = ordsProdsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        return new OrdsProdsResponseDto(entity);
    }
}
