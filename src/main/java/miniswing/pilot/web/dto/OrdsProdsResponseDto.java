package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.OrdsProds;
import miniswing.pilot.domain.Prods;

@Getter
public class OrdsProdsResponseDto {

    //private Long id;
    private long svc_mgmt_num1;
    private long acnt_num1;
    private Prods prods;
    private String svc_scrb_dt1;

    public OrdsProdsResponseDto(OrdsProds entity) {
        //this.id = entity.getId();
        this.svc_mgmt_num1 = entity.getSvc_mgmt_num1();
        this.acnt_num1 = entity.getAcnt_num1();
        this.prods = entity.getProds();
        this.svc_scrb_dt1 = entity.getSvc_scrb_dt1();
    }
}
