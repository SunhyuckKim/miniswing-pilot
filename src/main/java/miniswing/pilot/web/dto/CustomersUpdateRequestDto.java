package miniswing.pilot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomersUpdateRequestDto {

    private String cust_nm;
    private String gender_cd;

    @Builder
    public CustomersUpdateRequestDto(String cust_nm, String gender_cd) {
        this.cust_nm = cust_nm;
        this.gender_cd = gender_cd;
    }
}
