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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private long svc_mgmt_num1;

    @Column(length = 10, nullable = false)
    private long acnt_num1;

    @OneToOne
    @JoinColumn(name="prod_id")
    private Products products;

    @Column(length = 8, nullable = false)
    private String svc_scrb_dt1;


    @Builder
    public OrdsProds(long svc_mgmt_num1, long acnt_num1, Products products, String svc_scrb_dt1) {
        this.svc_mgmt_num1 = svc_mgmt_num1;
        this.acnt_num1 = acnt_num1;
        this.products = products;
        this.svc_scrb_dt1 = svc_scrb_dt1;
    }


}
