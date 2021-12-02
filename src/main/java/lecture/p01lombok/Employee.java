package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //모든 파라미터가 포함된 생성자
public class Employee {
	
	private int id;
	private String name;
	private String notes;
}
