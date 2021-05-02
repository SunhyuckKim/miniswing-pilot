package miniswing.pilot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String prod_id;

    @Column(length = 100, nullable = false)
    private String prod_nm;

    @Builder
    public Products(String prod_id, String prod_nm) {
        this.prod_id = prod_id;
        this.prod_nm = prod_nm;
    }

    public void update(String prod_id, String prod_nm) {
        this.prod_id = prod_id;
        this.prod_nm = prod_nm;
    }
}
