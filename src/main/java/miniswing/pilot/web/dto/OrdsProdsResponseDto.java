package miniswing.pilot.web.dto;

import lombok.Getter;
import lombok.Setter;
import miniswing.pilot.domain.OrdsProds;

@Getter
@Setter
public class OrdsProdsResponseDto {

    //private Long id;
    private long svc_mgmt_num;
    private long cust_num;
    private String prod_id;
    private String svc_scrb_dt;

    public OrdsProdsResponseDto(OrdsProds entity) {
        //this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
      //  this.cust_num = entity.getCustomers().getCust_num();
        this.cust_num = entity.getCust_num();
        this.prod_id = entity.getProds().getProd_id();
        this.svc_scrb_dt = entity.getSvc_scrb_dt();
    }
}
