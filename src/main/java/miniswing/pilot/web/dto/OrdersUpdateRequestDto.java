package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersUpdateRequestDto {
    //private Integer svc_mgmt_num;
    private Integer acnt_num;
    private String prod_id;
    private String svc_scrb_dt;

    @Builder
    public OrdersUpdateRequestDto(Integer acnt_num, String prod_id, String svc_scrb_dt) {
        //this.svc_mgmt_num = svc_mgmt_num;
        this.acnt_num = acnt_num;
        this.prod_id = prod_id;
        this.svc_scrb_dt = svc_scrb_dt;
    }
}
