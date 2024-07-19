package com.yedam.common;

import lombok.Data;

@Data
public class SearchVTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
