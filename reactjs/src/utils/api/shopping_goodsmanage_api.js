import axios from 'axios';

const ROOT_URL = 'http://localhost:8080';

export const getGoodsAll = () => axios.get(`${ROOT_URL}/api/goods/get-all`);
