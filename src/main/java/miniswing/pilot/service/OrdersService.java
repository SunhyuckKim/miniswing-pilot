package miniswing.pilot.service;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.domain.Orders;
import miniswing.pilot.domain.OrdersRepository;
import miniswing.pilot.web.dto.OrdersResponseDto;
import miniswing.pilot.web.dto.OrdersSaveRequestDto;
import miniswing.pilot.web.dto.OrdersUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Transactional //고객정보 저장
    public Long save(OrdersSaveRequestDto requestDto) {
        return ordersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, OrdersUpdateRequestDto requestDto) {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        orders.update(requestDto.getAcnt_num(), requestDto.getProd_id(), requestDto.getSvc_scrb_dt());

        return id;
    }


    //고객정보 조회
    public OrdersResponseDto findById(Long id) {
        Orders entity = ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        return new OrdersResponseDto(entity);
    }

}
