import { combineReducers } from 'redux';
import layout from './layout';
import shoppingGoodsManage from './shopping_goodsmanage';

const rootReducer = combineReducers({
  layout,
  shoppingGoodsManage,
});

export default rootReducer;
