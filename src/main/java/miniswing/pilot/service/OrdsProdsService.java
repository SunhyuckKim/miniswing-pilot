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
    public OrdsProdsResponseDto findById(long svc_mgmt_num) {
        OrdsProds entity = ordsProdsRepository.findById(svc_mgmt_num).orElseThrow(() -> new IllegalArgumentException("해당 서비스관리번호가 없습니다. =" + svc_mgmt_num));

        return new OrdsProdsResponseDto(entity);
    }
}
