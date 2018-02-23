package dream.blog.practice.ehcache.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DecimalFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserSerivceNotNull() {
		assertNotNull(userService);
	}
	
	@Test
	public void testUserServiceOnlyFetchedOnce() {
		//Arrange
		int expected = 1;
		
		//Act
		System.err.println("1:"+userService.findById(1));
		System.err.println("2:"+userService.findById(1));
		System.err.println("3:"+userService.findById(1));
		
		//Assert
		assertEquals(expected, userService.getMethodInvokedCount());
	}
	
	@Test
	public void testUserServiceFetchedTwiceWithEvict() {
		//Arrange
		int expected = 2;
		
		//Act
		System.err.println("1:"+userService.findById(1));
		System.err.println("2:"+userService.findById(1));
		System.err.println("3:"+userService.findByIdClearCache(1));
		
		//Assert
		assertEquals(expected, userService.getMethodInvokedCount());
	}
	
}
