import React from 'react';
import Header from './Header';
import Sidebar from './Sidebar';
import Board from './Board';

import styles from '../styles/layout/layout.module.scss';

const Layout = () => {
  return (
    <div className={styles.main}>
      <Header />
      <div className={styles.container}>
        <Sidebar />
        <Board />
      </div>
    </div>
  );
};

export default Layout;
