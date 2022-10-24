package namoo.springmvc.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User DTO
 * @author 김기정
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
	
	
}





