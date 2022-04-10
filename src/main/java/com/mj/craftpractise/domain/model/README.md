## 도메인 설계

### AbstractBaseEntity(부모 엔티티 - 추상클래스)
- @MappedSuperClass
- 등록일자, 등록한 사람, 수정일자, 수정한 사람
- 모든 엔티티가 공유하는 컬럼

### Goods(상품 테이블)
- 상품은 여러 카테고리에 속할 수 있다. (다대다 관계 - 상품_카테고리 연결테이블로 해결)

### Category(카테고리 테이블)
- ~~복합키로 구성(lcate, mcate, scate, dcate 4개 컬럼이 pk) => @EmbeddedId~~
- jpa에서 연결테이블에 복합키를 구성하기가 까다로워 별도 비식별 아이디 컬럼을 추가함. 
- lcate, mcate .. 등등 카테고리 코드가 pk가 아니므로 중복확인 및 시퀀스 자동증가를 직접 구현
- 카테고리는 여러 상품을 가진다. (다대다)
- 카테고리에 판매가표시 및 구매 권한을 설정가능하다. (운영자, 사용자 그룹 등)

### GoodsCategory(연결 테이블)
- GoodsCategory는 Goods 테이블, Goodscategory 테이블 각각의 기본키를 복합키로 가짐 (식별관계)
- ~~@EmbeddedId GoodsAndGoodscategoryId 클래스를 가짐~~
- ~~Goods, GoodsCategory 에서 @OneToMany mappedBy 설정할 때 `goodsAndGoodscategoryId.goods`, `goodsAndGoodscategoryId.goodscategory` 형식으로 매핑 지정~~
- `@IdClass`로 수정 (GoodsCategoryId)

