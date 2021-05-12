package miniswing.pilot.domain;

import miniswing.pilot.domain.Customers;
import miniswing.pilot.domain.CustomersRepository;
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
public class CustomersRepositoryTest {

    @Autowired
    CustomersRepository customersRepository;


    @After
    public void cleanup() {
        customersRepository.deleteAll();
    }

    @Test
    public void 고객정보_조회된다() {

        //given
        long svc_mgmt_num = 1234567890;
        long cust_num = 1000000000;
        String cust_nm = "김개똥";
        String gender_cd = "1";

        customersRepository.save(Customers.builder()
                .cust_num(cust_num)
                .cust_nm(cust_nm)
                .gender_cd(gender_cd)
                .svc_mgmt_num(svc_mgmt_num)
                .build());

        //when
        List<Customers> customersList = customersRepository.findAll();

        //then
        Customers customers = customersList.get(0);
        assertThat(customers.getCust_num()).isEqualTo(cust_num);
        assertThat(customers.getCust_nm()).isEqualTo(cust_nm);
        assertThat(customers.getGender_cd()).isEqualTo(gender_cd);
        assertThat(customers.getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
    }


}
