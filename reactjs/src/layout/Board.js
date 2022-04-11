import React from 'react';

import styles from '../styles/layout/board.module.scss';
import GoodsManage from '../view/shopping/GoodsManage';

const Board = ({ children }) => {
  return (
    <div className={styles.board}>
      <GoodsManage />
    </div>
  );
};

export default Board;
