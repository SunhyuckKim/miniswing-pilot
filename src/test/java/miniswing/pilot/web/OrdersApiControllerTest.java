package miniswing.pilot.web;


import miniswing.pilot.domain.Orders;
import miniswing.pilot.domain.OrdersRepository;
import miniswing.pilot.web.dto.OrdersSaveRequestDto;
import miniswing.pilot.web.dto.OrdersUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrdersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrdersRepository ordersRepository;

    @After
    public void tearDown() throws Exception {
        ordersRepository.deleteAll();
    }

    @Test
    public void 오더정보_등록된다() throws Exception {

        //given
        Integer svc_mgmt_num = 1234567890;
        Integer acnt_mum = 1234567890;
        String prod_id = "NA00000000";
        String svc_scrb_dt = "20210428";
        OrdersSaveRequestDto requestDto = OrdersSaveRequestDto.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .acnt_num(acnt_mum)
                .prod_id(prod_id)
                .svc_scrb_dt(svc_scrb_dt)
                .build();

        String url = "http://localhost:" + port + "/api/v1/orders";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Orders> all = ordersRepository.findAll();
        assertThat(all.get(0).getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(all.get(0).getAcnt_num()).isEqualTo(acnt_mum);
        assertThat(all.get(0).getProd_id()).isEqualTo(prod_id);
        assertThat(all.get(0).getSvc_scrb_dt()).isEqualTo(svc_scrb_dt);
    }

    @Test
    public void 오더정보_수정된다() throws Exception {

        //given
        Integer svc_mgmt_num = 1234567890;
        Integer acnt_mum = 1234567890;
        String prod_id = "NA00000000";
        String svc_scrb_dt = "20210428";

        Orders savedOrders = ordersRepository.save(Orders.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .acnt_num(acnt_mum)
                .prod_id(prod_id)
                .svc_scrb_dt(svc_scrb_dt)
                .build());

        Long updateId = savedOrders.getId();
        //Integer expectedSvc_mgmt_num = 1234567891;
        Integer expectedAcnt_num = 1234567891;
        String expectedProd_id = "NA00000002";
        String expectedSvc_scrb_dt = "20210429";

        OrdersUpdateRequestDto requestDto = OrdersUpdateRequestDto.builder()
                .acnt_num(expectedAcnt_num)
                .prod_id(expectedProd_id)
                .svc_scrb_dt(expectedSvc_scrb_dt)
                .build();

        String url = "http://localhost:" + port + "/api/v1/orders" + updateId;

        HttpEntity<OrdersUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Orders> all = ordersRepository.findAll();
//        assertThat(all.get(0).getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(all.get(0).getAcnt_num()).isEqualTo(expectedAcnt_num);
        assertThat(all.get(0).getProd_id()).isEqualTo(expectedProd_id);
        assertThat(all.get(0).getSvc_scrb_dt()).isEqualTo(expectedSvc_scrb_dt);
    }
}
