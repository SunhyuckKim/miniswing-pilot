package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.Customers;

@Getter
public class CustomersResponseDto {
//    private Long id;
    private long cust_num;
    private String cust_nm;
    private String gender_cd;
    private long svc_mgmt_num;

    public CustomersResponseDto(Customers entity) {
//        this.id = entity.getId();
        this.cust_num = entity.getCust_num();
        this.cust_nm = entity.getCust_nm();
        this.gender_cd = entity.getGender_cd();
        this.svc_mgmt_num = entity.getSvc_mgmt_num();
    }
}
