package org.zerock.domain.project1;

import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.Data;

@Data
public class ReplyVO {
	private Integer id;
	private Integer boardId;
	private String memberId;
	private String reply;
	private LocalDateTime inserted;
	private LocalDateTime updated;
	
	public Boolean own;

	private String nickName;
	
	public String getCustomInserted() {
		//νμ¬ μΌμ
		LocalDateTime now = LocalDateTime.now(ZoneId.of("+09:00"));
		LocalDateTime beforeOneDayFromNow = now.minusDays(1);
		
		if(inserted.isBefore(beforeOneDayFromNow)) {
			return inserted.toLocalDate().toString();
		}else {
			return inserted.toLocalTime().toString();
		}
	}
}

