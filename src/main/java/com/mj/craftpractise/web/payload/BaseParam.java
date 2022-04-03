package com.mj.craftpractise.web.payload;

public class BaseParam {
    
    private int currentPage;
    private int rowsPerPage;
    private long totalCount;
    private int rowNum;
    private String custNo;
    private String memberId;
    private String fromDate;
    private String toDate;
    private int period;   // 기간
    private String nowDate; // 오늘 날짜
    private String searchkey;    // 검색 문구
    private boolean isLogin;
}