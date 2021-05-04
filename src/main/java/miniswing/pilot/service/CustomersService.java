package miniswing.pilot.service;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.domain.Customers;
import miniswing.pilot.domain.CustomersRepository;
import miniswing.pilot.web.dto.CustomersResponseDto;
import miniswing.pilot.web.dto.CustomersSaveRequestDto;
import miniswing.pilot.web.dto.CustomersUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    //고객정보조회
    public CustomersResponseDto findById(Long id) {
        Customers entity = customersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        return new CustomersResponseDto(entity);
    }

    @Transactional //고객정보 저장
    public Long save(CustomersSaveRequestDto requestDto) {
        return customersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CustomersUpdateRequestDto requestDto) {
        Customers customers = customersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        customers.update(requestDto.getCust_nm(), requestDto.getGender_cd());

        return id;
    }
}
