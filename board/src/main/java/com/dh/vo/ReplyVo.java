package com.dh.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString @NoArgsConstructor
public class ReplyVo {

	private int bno;
	private int rno;
	private String content;
	private String writer;
	private String regdate;
	
}
