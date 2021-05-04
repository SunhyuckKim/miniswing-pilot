package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.OrdsProds;
import miniswing.pilot.domain.Products;

@Getter
public class OrdsProdsResponseDto {

    private Long id;
    private long svc_mgmt_num1;
    private long acnt_num1;
    private Products products;
    private String svc_scrb_dt1;

    public OrdsProdsResponseDto(OrdsProds entity) {
        this.id = entity.getId();
        this.svc_mgmt_num1 = entity.getSvc_mgmt_num1();
        this.acnt_num1 = entity.getAcnt_num1();
        this.products = entity.getProducts();
        this.svc_scrb_dt1 = entity.getSvc_scrb_dt1();
    }
}
