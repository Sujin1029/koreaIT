package namoo.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class LogTest {
//	Logger log = LoggerFactory.getLogger(LogTest.class); 	// 대신 @Slf4j 어노테이션 사용
	
	// + 연산자 쓰지 말고 {} , 다음 변수 넣기)
	String name = "함수진";
	@Test
	void logTest() {
		log.trace("trace 출력 : {}", name);
		log.debug("debug 출력 : {}", name);
		log.info("info 출력 : {}", name);
		log.warn("warn 출력 : {}", name);
		log.error("error 출력 : {}", name);
	}
}