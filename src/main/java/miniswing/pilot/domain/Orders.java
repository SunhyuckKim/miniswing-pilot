package miniswing.pilot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private Integer svc_mgmt_num;

    @Column(length = 10, nullable = false)
    private Integer acnt_num;

    @Column(length = 10, nullable = false)
    private String prod_id;

    @Column(length = 8, nullable = false)
    private String svc_scrb_dt;

    @Builder
    public Orders(Integer svc_mgmt_num, Integer acnt_num, String prod_id, String svc_scrb_dt) {
        this.svc_mgmt_num = svc_mgmt_num;
        this.acnt_num = acnt_num;
        this.prod_id = prod_id;
        this.svc_scrb_dt = svc_scrb_dt;
    }

    public void update(Integer acnt_num, String prod_id, String svc_scrb_dt) {
        this.acnt_num = acnt_num;
        this.prod_id = prod_id;
        this.svc_scrb_dt = svc_scrb_dt;
    }

}
