package namoo.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@SpringBootTest
@Transactional	// aop 개념 자동 롤백 (실제 db에는 없음)
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findAll() {
		List<User> list = userService.findUsers();
		System.out.println(list);
	}


	@Test
	public void findUser() {
		String id = "bangry";
		User findUser = userService.findUser(id);
		System.out.println(findUser);
	}
	
	@Test
	public void registUser() {
		User user = new User();
		user.setId("hehe");
		user.setPasswd("1111");
		user.setName("김몽");
		user.setEmail("asfa@naver.com");
		userService.registUser(user);
		System.out.println("등록");
	}
}





