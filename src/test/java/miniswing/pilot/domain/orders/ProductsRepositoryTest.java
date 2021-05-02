package miniswing.pilot.domain.orders;

import miniswing.pilot.domain.Products;
import miniswing.pilot.domain.ProductsRepository;
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
public class ProductsRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @After
    public void cleanup() {
        productsRepository.deleteAll();
    }

    @Test
    public void 상품정보_조회된다() {

        //given
        String prod_id = "NA00000002";
        String prod_nm = "기본요금제";

        productsRepository.save(Products.builder()
                .prod_id(prod_id)
                .prod_nm(prod_nm)
                .build());

        //when
        List<Products> productsList = productsRepository.findAll();

        //then
        Products products = productsList.get(0);
        assertThat(products.getProd_id()).isEqualTo(prod_id);
        assertThat(products.getProd_nm()).isEqualTo(prod_nm);
    }

}

