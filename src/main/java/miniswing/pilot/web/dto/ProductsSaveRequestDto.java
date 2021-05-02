package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import miniswing.pilot.domain.Products;

@Getter
@NoArgsConstructor
public class ProductsSaveRequestDto {

    private String prod_id;
    private String prod_nm;
    @Builder
    public ProductsSaveRequestDto(String prod_id, String prod_nm) {
        this.prod_id = prod_id;
        this.prod_nm = prod_nm;
    }

    public Products toEntity(){
        return Products.builder()
                .prod_id(prod_id)
                .prod_nm(prod_nm)
                .build();
    }
}
