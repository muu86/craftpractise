package mj.craftpractise.domain.model.goods;

public class GoodsQuest {
    
    private Long id;
    
    private Long custNo;
    private String memId;
    
    private String goodsCode;
    private String goodsName;
    
    private int lGroup;
    private int MGroup;
    private int SGroup;
    private int DGroup;
    
    private String questTitle;
    private String questContents;
    
    private String processDate;
    private String processStatus;
    
    private int inquiryCnt; // 조회수
    private int answerCnt;  // 답변수
    
    private boolean deleteYn // 삭제여부
    private boolean secretYn    // 비밀글
    
}