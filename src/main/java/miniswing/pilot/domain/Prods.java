package miniswing.pilot.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Prods {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, nullable = false)
    private String prod_id;

    @Column(length = 100, nullable = false)
    private String prod_nm;

    @Builder
    public Prods(String prod_id, String prod_nm) {
        this.prod_id = prod_id;
        this.prod_nm = prod_nm;
    }
}
