package mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.model.goods.GoodsCategory;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MapsId;

public class GoodsCommentImage {
    
    private Long commentSeq;
    private Long goodsCode;
    private Long imageSeq;
    private String imageUrl;
    
}