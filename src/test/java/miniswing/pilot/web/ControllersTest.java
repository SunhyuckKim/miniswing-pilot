package miniswing.pilot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Controllers.class)

public class ControllersTest {

    @Autowired //Bean 주입받음
    private MockMvc mvc; //GET POST 등 API 테스트 가능

    @Test
    public void miniswing_리턴됨() throws Exception {
        String miniswing = "miniswing";

        mvc.perform(get("/miniswing"))
                .andExpect(status().isOk())
                .andExpect(content().string(miniswing));
    }

    @Test
    public void miniswingdto_리턴됨() throws Exception {
        String name = "miniswing";
        int number = 2021;

        mvc.perform(get("/miniswing/dto")
                .param("name",name).param("number", String.valueOf(number)))  //문구형태로만 보낼 수 있으므로 파라미터를 스트링 형태로 변경 필요
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.number",is(number)));
    }
}
