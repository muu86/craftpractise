import { handleActions } from 'redux-actions';
import * as api from '../utils/api/shopping_goodsmanage_api';
import createRequestThunk from '../utils/redux_thunk/createRequestThunk';

const GET_GOODS_ALL = 'shopping_goodsmanage/GET_GOODS';
const GET_GOODS_SUCCESS = 'shopping_goodsmanage/GET_GOODS_SUCCESS';
const GET_GOODS_FAILURE = 'shopping_goodsmanage/GET_GOODS_FAILURE';

export const getGoodsAll = createRequestThunk(GET_GOODS_ALL, api.getGoodsAll);

const initialState = {
  goods: null,
};

const shoppingGoodsManage = handleActions(
  {
    [GET_GOODS_ALL]: (state) => ({
      ...state,
    }),
    [GET_GOODS_SUCCESS]: (state, { payload }) => ({
      ...state,
      goods: payload,
    }),
    [GET_GOODS_FAILURE]: (state, { payload }) => ({
      ...state,
    }),
  },
  initialState
);

export default shoppingGoodsManage;
