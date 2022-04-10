package com.mj.craftpractise;

import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.domain.model.goods.repository.GoodsRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CraftpractiseApplicationTests {

	@Test
	void contextLoads() {
	}

	@PersistenceContext
	EntityManager em;

	@Autowired
	GoodsRepository goodsRepository;

	@Test
	@Transactional
	public void test() {
		Goods goods = new Goods();
		goods.setGoodsName("상품1");
		goods.setDescription("상세 설명");
		Goods savedGoods = goodsRepository.save(goods);

		System.out.println(goods.hashCode());
		System.out.println(savedGoods.hashCode());
		Assertions.assertThat(goods).isEqualTo(savedGoods);
	}
}
