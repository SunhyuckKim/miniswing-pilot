package miniswing.pilot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity


public class Customers {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private long cust_num;


    @Column(length = 10, nullable = false)
    private long svc_mgmt_num;

//    @Column(length = 10, nullable = false)
//    private long cust_num;

    @Column(length = 100, nullable = false)
    private String cust_nm;

    @Column(length = 1, nullable = false)
    private String gender_cd;

    @Builder
    public Customers(long cust_num, long svc_mgmt_num,  String cust_nm, String gender_cd) {
        this.cust_num = cust_num;
        this.cust_nm = cust_nm;
        this.svc_mgmt_num = svc_mgmt_num;
        this.gender_cd = gender_cd;
    }
    public void update(String cust_nm, String gender_cd) {
        this.cust_nm = cust_nm;
        this.gender_cd = gender_cd;
    }
}
