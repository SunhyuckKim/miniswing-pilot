package miniswing.pilot.domain.orders;

import miniswing.pilot.domain.Orders;
import miniswing.pilot.domain.OrdersRepository;
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
public class OrdersRepositoryTest {

    @Autowired
    OrdersRepository ordersRepository;

    @After
    public void cleanup() {
        ordersRepository.deleteAll();
    }

    @Test
    public void 오더정보_조회된다() {

        //given
        long svc_mgmt_num = 1234567890;
        long acnt_num = 1234567890;
        String prod_id = "NA00000001";
        String svc_scrb_dt = "20210428";

        ordersRepository.save(Orders.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .acnt_num(acnt_num)
                .prod_id(prod_id)
                .svc_scrb_dt(svc_scrb_dt)
                .build());

        //when
        List<Orders> ordersList = ordersRepository.findAll();

        //then
        Orders orders = ordersList.get(0);
        assertThat(orders.getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(orders.getAcnt_num()).isEqualTo(acnt_num);
        assertThat(orders.getProd_id()).isEqualTo(prod_id);
        assertThat(orders.getSvc_scrb_dt()).isEqualTo(svc_scrb_dt);
    }

}
