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
    @Column(name = "svc_mgmt_num")
    private long svc_mgmt_num;


//    @Column(length = 10, nullable = false)
//    private long cust_num;


    @Column(length = 8, nullable = false)
    private String svc_scrb_dt;

    @ManyToOne
    @JoinColumn(name="prod_id")
    private Prods prods;

    @OneToOne
    @JoinColumn(name="cust_num")
    private Customers customers;



    @Builder
    public OrdsProds(long svc_mgmt_num, Customers customers, Prods prods, String svc_scrb_dt) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.customers = customers;
        this.prods = prods;
        this.svc_scrb_dt = svc_scrb_dt;
    }


}
