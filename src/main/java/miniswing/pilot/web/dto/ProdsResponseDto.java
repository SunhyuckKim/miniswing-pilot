package miniswing.pilot.web.dto;

import lombok.Getter;
import miniswing.pilot.domain.Prods;


@Getter

public class ProdsResponseDto {

    //private Long id;
    private String prod_id;
    private String prod_nm;

    public ProdsResponseDto(Prods entity) {
        //this.id = entity.getId();
        this.prod_id = entity.getProd_id();
        this.prod_nm = entity.getProd_nm();
    }
}
