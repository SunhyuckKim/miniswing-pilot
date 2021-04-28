package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.Orders;

@Getter
public class OrdersResponseDto {

    private Long id;
    private Integer svc_mgmt_num;
    private Integer acnt_num;
    private String prod_id;
    private String svc_scrb_dt;

    public OrdersResponseDto(Orders entity) {
        this.id = entity.getId();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
        this.acnt_num = entity.getAcnt_num();
        this.prod_id = entity.getProd_id();
        this.svc_scrb_dt = entity.getSvc_scrb_dt();
    }
}
