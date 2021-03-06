package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import miniswing.pilot.domain.Customers;

@Getter
@NoArgsConstructor
public class CustomersSaveRequestDto {

    private long cust_num;
    private String cust_nm;
    private String gender_cd;
    private long svc_mgmt_num;

    @Builder
    public CustomersSaveRequestDto(long cust_num, String cust_nm, String gender_cd, long svc_mgmt_num ) {
        this.cust_num = cust_num;
        this.cust_nm = cust_nm;
        this.gender_cd = gender_cd;
        this.svc_mgmt_num = svc_mgmt_num;
    }

    public Customers toEntity(){
        return Customers.builder()
                .cust_num(cust_num)
                .cust_nm(cust_nm)
                .gender_cd(gender_cd)
                .svc_mgmt_num(svc_mgmt_num)
                .build();
    }
}
