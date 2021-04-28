package miniswing.pilot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDtoTest {

    @Test
    public void 롬복기능_Test() {
        //given
        String name = "miniswing";
        int number = 2021;

        //when
        ResponseDto dto = new ResponseDto(name,number);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getNumber()).isEqualTo(number);
    }
}
