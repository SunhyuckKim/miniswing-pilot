package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsUpdateRequestDto {


    private String prod_id;
    private String prod_nm;

    @Builder
    public ProductsUpdateRequestDto(String prod_id, String prod_nm) {
        this.prod_id = prod_id;
        this.prod_nm = prod_nm;
    }
}
