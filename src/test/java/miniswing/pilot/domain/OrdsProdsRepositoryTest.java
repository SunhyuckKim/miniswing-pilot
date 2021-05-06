package miniswing.pilot.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdsProdsRepositoryTest {

    @Autowired
    OrdsProdsRepository ordsProdsRepository;

    @Autowired
    ProductsRepository productsRepository;

    @After
    public void cleanup() {
        ordsProdsRepository.deleteAll();
    }

    @Test
    public void 오더상품정보_조회된다() {

        //given
        long svc_mgmt_num1 = 1234567890;
        long acnt_num1 = 1234567890;
        String prod_id = "NA00000001";
        String svc_scrb_dt1 = "20210428";

        ordsProdsRepository.save(OrdsProds.builder()
                .svc_mgmt_num1(svc_mgmt_num1)
                .acnt_num1(acnt_num1)
                //.prod_id
                .svc_scrb_dt1(svc_scrb_dt1)
                .build());

        //when
        List<OrdsProds> ordsProdsList = ordsProdsRepository.findAll();

        //then
        OrdsProds ordsProds = ordsProdsList.get(0);
        assertThat(ordsProds.getSvc_mgmt_num1()).isEqualTo(svc_mgmt_num1);
        assertThat(ordsProds.getAcnt_num1()).isEqualTo(acnt_num1);
        assertThat(ordsProds.getProds()).isEqualTo(prod_id);
        assertThat(ordsProds.getSvc_scrb_dt1()).isEqualTo(svc_scrb_dt1);
    }

}
