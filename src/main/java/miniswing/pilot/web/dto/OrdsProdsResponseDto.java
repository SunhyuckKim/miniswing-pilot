package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.OrdsProds;


@Getter
public class OrdsProdsResponseDto {

    //private Long id;
    private long svc_mgmt_num;
    private long cust_num;
    private String prod_id;
    private String svc_scrb_dt;
    private String prod_nm;
    private String cust_nm;

    public OrdsProdsResponseDto(OrdsProds entity) {
        //this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
      //  this.cust_num = entity.getCustomers().getCust_num();
        this.cust_num = entity.getCustomers().getCust_num();
        this.cust_nm = entity.getCustomers().getCust_nm();
        this.prod_id = entity.getProds().getProd_id();
        this.prod_nm = entity.getProds().getProd_nm();
        this.svc_scrb_dt = entity.getSvc_scrb_dt();
    }
}
