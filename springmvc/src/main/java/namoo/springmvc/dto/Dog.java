package namoo.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data	//최상위 어노테이션(디폴트 생성)
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
	private String name;
	private int age;
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(10);
		dog.setName("김푸들");
		System.out.println(dog.toString());
	}
}
