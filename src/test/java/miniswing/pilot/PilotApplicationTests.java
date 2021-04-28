package miniswing.pilot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PilotApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void 테스트_1() {
		assertThat(1).isEqualTo(1);
	}

}
