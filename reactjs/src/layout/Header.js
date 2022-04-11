import React, { useCallback } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { sidebarOpen } from '../store/layout';
import styles from '../styles/layout/header.module.scss';

const Header = ({ children }) => {
  const open = useSelector(({ layout }) => layout.open);
  const dispatch = useDispatch();
  const onSidebarOpen = useCallback(() => dispatch(sidebarOpen()), [dispatch]);

  return (
    <div className={styles.header}>
      <div className={styles.logo}>
        <span className="material-icons" onClick={onSidebarOpen}>
          {open ? 'keyboard_double_arrow_left' : 'keyboard_double_arrow_right'}
        </span>
        <span className={styles.craftpractise}>craftpractise</span>
      </div>

      <div className={styles.logout}>
        <button>나가기</button>
      </div>
    </div>
  );
};

export default Header;
