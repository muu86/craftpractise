package mj.craftpractise.domain.model.order;

public class OrderStock {
    
    private Long goodsCode;
    private Long goodsDtCode;
    
    // whCode 창고코드
    
    private int orderQty;   // 주문수량
    private int outPlanQty; // 출하예정수량
    private int totalSaleQty;
}