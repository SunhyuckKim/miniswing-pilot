package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.Products;

@Getter
public class ProductsResponseDto {

    private Long id;
    private String prod_id;
    private String prod_nm;

    public ProductsResponseDto(Products entity) {
        this.id = entity.getId();
        this.prod_id = entity.getProd_id();
        this.prod_nm = entity.getProd_nm();
    }
}
