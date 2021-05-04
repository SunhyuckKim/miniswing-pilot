package miniswing.pilot.web;

import miniswing.pilot.domain.Products;
import miniswing.pilot.domain.ProductsRepository;
import miniswing.pilot.web.dto.ProductsSaveRequestDto;
import miniswing.pilot.web.dto.ProductsUpdateRequestDto;
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

public class ProductsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductsRepository productsRepository;

    @After
    public void tearDown() throws Exception {
        productsRepository.deleteAll();
    }

    @Test
    public void 상품정보_등록된다() throws Exception {

        //given
        String prod_id = "NA00000001";
        String prod_nm = "기본요금제";
        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
                .prod_id(prod_id)
                .prod_nm(prod_nm)
                .build();

        String url = "http://localhost:" + port + "/api/v1/products";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Products> all = productsRepository.findAll();
        assertThat(all.get(0).getProd_id()).isEqualTo(prod_id);
        assertThat(all.get(0).getProd_nm()).isEqualTo(prod_nm);
    }

    @Test
    public void 상품정보_수정된다() throws Exception {

        //given
        String prod_id = "NA00000001";
        String prod_nm = "부가요금제";

        Products savedProducts = productsRepository.save(Products.builder()
                .prod_id(prod_id)
                .prod_nm(prod_nm)
                .build());

        Long updateId = savedProducts.getId();
        String expectedProd_id = "NA00000001";
        String expectedProd_nm = "기본요금제";

        ProductsUpdateRequestDto requestDto = ProductsUpdateRequestDto.builder()
                .prod_id(expectedProd_id)
                .prod_nm(expectedProd_nm)
                .build();

        String url = "http://localhost:" + port + "/api/v1/products/" + updateId;

        HttpEntity<ProductsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Products> all = productsRepository.findAll();
//        assertThat(all.get(0).getSvc_mgmt_num()).isEqualTo(svc_mgmt_num);
        assertThat(all.get(0).getProd_id()).isEqualTo(expectedProd_id);
        assertThat(all.get(0).getProd_nm()).isEqualTo(expectedProd_nm);
    }
}
