package miniswing.pilot.service;

import lombok.RequiredArgsConstructor;
import miniswing.pilot.domain.Products;
import miniswing.pilot.domain.ProductsRepository;
import miniswing.pilot.web.dto.ProductsResponseDto;
import miniswing.pilot.web.dto.ProductsSaveRequestDto;
import miniswing.pilot.web.dto.ProductsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

public class ProductsService {

    private final ProductsRepository productsRepository;

    @Transactional //상품정보 저장
    public Long save(ProductsSaveRequestDto requestDto) {
        return productsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional //상품정보변경
    public Long update(Long id, ProductsUpdateRequestDto requestDto) {
        Products products = productsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        products.update( requestDto.getProd_id(), requestDto.getProd_nm());

        return id;
    }

    //상품정보조회
    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 서비스가 없습니다. id=" + id));

        return new ProductsResponseDto(entity);
    }
}

