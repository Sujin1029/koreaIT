package namoo.springmvc.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	// 회원 목록 처리
	@GetMapping
	public String list(@RequestParam(required = false, defaultValue = "") String type, @RequestParam(required = false, defaultValue = "") String value,  Model model) {
//		List<User> list = userService.findUsers();
		log.info("검색타입: {}, 검색값: {}", type, value);
		List<User> list = userService.search(type, value);
		log.info("사용자 리스트 : {}", list);
		model.addAttribute("list", list);
		return "user/users";
	}

	// 회원 상세 보기
	@GetMapping("/{id}")
	public String view(@PathVariable String id, @RequestParam(value = "result" , required = false) boolean result, Model model) {
		User user = userService.findUser(id);
		model.addAttribute("user", user); // 저장할 때 이름
		model.addAttribute("result", result);
		return "user/view";
	}

	// 회원 등록 화면 처리 (js 유효성 검증하기)
	@GetMapping("/regist")
	public String form() {
		return "user/regist";
	}

	// 회원 등록 처리 (서버)
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user, RedirectAttributes redirectAttributes) { // @ModelAttribute 사용 시 Model 사용 안 해도 됨
		userService.registUser(user);
		User findUser = userService.findUser(user.getId());
		redirectAttributes.addAttribute("id", findUser.getId());
		redirectAttributes.addAttribute("name", findUser.getName());
		redirectAttributes.addAttribute("email", findUser.getEmail());
		redirectAttributes.addAttribute("regdate", findUser.getRegdate());
		redirectAttributes.addAttribute("result", true);	// 등록 or 실패 확인 결과 알려줌
		return "redirect:/users/{id}";
	}


}
