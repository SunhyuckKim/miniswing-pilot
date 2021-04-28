package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import miniswing.pilot.domain.Orders;

@Getter
@NoArgsConstructor
public class OrdersSaveRequestDto {

    private Integer svc_mgmt_num;
    private Integer acnt_num;
    private String prod_id;
    private String svc_scrb_dt;
    @Builder
    public OrdersSaveRequestDto(Integer svc_mgmt_num, Integer acnt_num, String prod_id, String svc_scrb_dt) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.acnt_num = acnt_num;
        this.prod_id = prod_id;
        this.svc_scrb_dt = svc_scrb_dt;
    }

    public Orders toEntity(){
        return Orders.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .acnt_num(acnt_num)
                .prod_id(prod_id)
                .svc_scrb_dt(svc_scrb_dt)
                .build();
    }


}
