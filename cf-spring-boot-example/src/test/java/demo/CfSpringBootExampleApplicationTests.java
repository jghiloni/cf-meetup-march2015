package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecsteam.boot.SpringBootExampleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootExampleApplication.class)
@WebAppConfiguration
public class CfSpringBootExampleApplicationTests {

	@Test
	public void contextLoads() {
	}

}
