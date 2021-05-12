package miniswing.pilot.domain;

import org.junit.After;
import org.junit.Before;
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
    ProdsRepository prodsRepository;

    @Autowired
    CustomersRepository customersRepository;

    List<Prods> prods;
    List<Customers> customers;

    @Before
    public void setup() {
        prods = prodsRepository.findAll();
        customers = customersRepository.findAll();
    }

    @After
    public void cleanup() {
        ordsProdsRepository.deleteAll();
    }

    @Test
    public void 오더상품정보_조회된다() {

        //given
        long svc_mgmt_num = 1234567891;
        long cust_num = 1000000001;
        String prod_id = "NA00000001";
        String svc_scrb_dt = "20210428";

        ordsProdsRepository.save(OrdsProds.builder()
                .svc_mgmt_num(svc_mgmt_num)
//                .customers.getCust_num(cust_num)
                .prods(prods.get(0))
//                .customers(customers.get(0))
                //.prods(prods)
                .svc_scrb_dt(svc_scrb_dt)
                .build());

        //when
        List<OrdsProds> ordsProdsList = ordsProdsRepository.findAll();

        //then
        OrdsProds ordsProds = ordsProdsList.get(0);
        assertThat(ordsProds.getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
//        assertThat(ordsProds.getCust_num()).isEqualTo(cust_num);
        assertThat(ordsProds.getProds()).isEqualTo(prods.get(0));
//        assertThat(ordsProds.getCustomers()).isEqualTo(customers.get(0));
        assertThat(ordsProds.getSvc_scrb_dt()).isEqualTo(svc_scrb_dt);
    }

}
