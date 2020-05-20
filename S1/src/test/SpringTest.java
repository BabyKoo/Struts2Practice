package test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author 古学懂_Victor
* @date 2020年5月13日
*/
class SpringTest {

	@Test
	void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		fail("Not yet implemented");
	}

}
