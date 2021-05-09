package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.Customers;
import miniswing.pilot.domain.OrdsProds;
import miniswing.pilot.domain.Prods;

@Getter
public class OrdsProdsResponseDto {

    //private Long id;
    private long svc_mgmt_num;
    private Customers customers;
    private Prods prods;
    private String svc_scrb_dt;

    public OrdsProdsResponseDto(OrdsProds entity) {
        //this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
        this.customers = entity.getCustomers();
        this.prods = entity.getProds();
        this.svc_scrb_dt = entity.getSvc_scrb_dt();
    }
}
