package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //생성자
@NoArgsConstructor //파라미터 없는 생성자
public class Supplier {
	private int id;
	private String name;
	private String address;
	private String country;
}
