## 도메인 설계

### AbstractBaseEntity(부모 엔티티 - 추상클래스)
- @MappedSuperClass
- 등록일자, 등록한 사람, 수정일자, 수정한 사람
- 모든 엔티티가 공유하는 컬럼

### Goods(상품 테이블)
- 상품은 여러 카테고리에 속할 수 있다. (다대다 관계 - 상품_카테고리 연결테이블로 해결)

### GoodsCategory(카테고리 테이블)
- 복합키로 구성(lcate, mcate, scate, dcate 4개 컬럼이 pk) => @EmbeddedId
- 카테고리는 여러 상품을 가진다. (다대다)
- 카테고리에 판매가표시 및 구매 권한을 설정가능하다. (운영자, 사용자 그룹 등)

### GoodsAndGoodsCategory(연결 테이블)
- GoodsAndGoodsCategory는 Goods 테이블, GoodsCategory 테이블 각각의 기본키를 복합키로 가짐 (식별관계)
- @EmbeddedId GoodsAndGoodsCategoryId 클래스를 가짐
- Goods, GoodsAndGoodsCategory 에서 @OneToMany mappedBy 설정할 때 `goodsAndGoodsCategoryId.goods`, `goodsAndGoodsCategoryId.goodsCategory` 형식으로 매핑 지정