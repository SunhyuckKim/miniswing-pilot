package miniswing.pilot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity

public class OrdsProds {

    @Id
    @GeneratedValue
    //(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private String id;

    @Column(length = 10, nullable = false)
    private long svc_mgmt_num1;

    @Column(length = 10, nullable = false)
    private long acnt_num1;

//    @Column(length = 8, nullable = false)
//    private Products products;

    @Column(length = 8, nullable = false)
    private String svc_scrb_dt1;

    @OneToOne
    @JoinColumn(name="prod_id")
    private Prods prods;


    @Builder
    public OrdsProds(long svc_mgmt_num1, long acnt_num1, Prods prods, String svc_scrb_dt1) {
        this.svc_mgmt_num1 = svc_mgmt_num1;
        this.acnt_num1 = acnt_num1;
        this.prods = prods;
        this.svc_scrb_dt1 = svc_scrb_dt1;
    }


}
