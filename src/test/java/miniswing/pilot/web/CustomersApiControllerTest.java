package miniswing.pilot.web;

import miniswing.pilot.domain.Customers;
import miniswing.pilot.domain.CustomersRepository;
import miniswing.pilot.domain.Orders;
import miniswing.pilot.web.dto.CustomersSaveRequestDto;
import miniswing.pilot.web.dto.CustomersUpdateRequestDto;
import miniswing.pilot.web.dto.OrdersSaveRequestDto;
import miniswing.pilot.web.dto.OrdersUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomersRepository customersRepository;

    @After
    public void tearDown() throws Exception {
        customersRepository.deleteAll();
    }

    @Test
    public void 고객정보_등록된다() throws Exception {

        //given
        long svc_mgmt_num = 1234567890;
        long cust_num = 1234567890;
        String cust_nm = "김개똥";
        String gender_cd = "1";
        CustomersSaveRequestDto requestDto = CustomersSaveRequestDto.builder()
                .svc_mgmt_num(svc_mgmt_num)
                .cust_num(cust_num)
                .cust_nm(cust_nm)
                .gender_cd(gender_cd)
                .build();

        String url = "http://localhost:" + port + "/api/v1/customers";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Customers> all = customersRepository.findAll();
        assertThat(all.get(0).getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(all.get(0).getCust_num()).isEqualTo(cust_num);
        assertThat(all.get(0).getCust_nm()).isEqualTo(cust_nm);
        assertThat(all.get(0).getGender_cd()).isEqualTo(gender_cd);
    }

    @Test
    public void 고객정보_수정된다() throws Exception {

        //given
        String cust_nm = "언년이";
        String gender_cd = "2";

        Customers savedCustomers = customersRepository.save(Customers.builder()
                .cust_nm(cust_nm)
                .gender_cd(gender_cd)
                .build());

        Long updateId = savedCustomers.getId();
        String expectedCust_nm = "언년이";
        String expectedGender_cd = "2";

         CustomersUpdateRequestDto requestDto = CustomersUpdateRequestDto.builder()
                .cust_nm(expectedCust_nm)
                .gender_cd(expectedGender_cd)
                .build();

        String url = "http://localhost:" + port + "/api/v1/customers/" + updateId;

        HttpEntity<CustomersUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Customers> all = customersRepository.findAll();
//        assertThat(all.get(0).getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(all.get(0).getCust_nm()).isEqualTo(expectedCust_nm);
        assertThat(all.get(0).getGender_cd()).isEqualTo(expectedGender_cd);
    }
}
