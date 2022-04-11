import React, { useCallback, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { goodsTableHeader } from '../../menu_items/goods_table';
import { getGoodsAll } from '../../store/shopping_goodsmanage';
import styles from '../../styles/view/goodsmanage.module.scss';

const GoodsManage = () => {
  const goods = useSelector(
    ({ shoppingGoodsManage }) => shoppingGoodsManage.goods
  );
  const dispatch = useDispatch();
  const callGetGoodsAll = useCallback(
    () => dispatch(getGoodsAll()),
    [dispatch]
  );

  useEffect(() => {
    try {
      callGetGoodsAll();
    } catch (e) {
      console.log(e);
    }
  }, []);

  useEffect(() => {
    console.log(goods);
  }, [goods]);

  return (
    <section>
      <div>
        <table>
          <thead>
            <tr>
              <th>No</th>
              <th>상품명</th>
              <th>판매가</th>
              <th>카테고리</th>
              <th>상태</th>
              <th>재고</th>
              <th>등록일</th>
              <th>수정일</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>패턴머그999</td>
              <td>2000</td>
              <td>컵</td>
              <td>판매중</td>
              <td>1</td>
              <td>1</td>
            </tr>
          </tbody>
        </table>
      </div>
    </section>
  );
};

export default GoodsManage;
