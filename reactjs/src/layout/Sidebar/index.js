import React, { useCallback } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { sidebarOpen } from '../../store/layout';

import styles from '../../styles/layout/sidebar.module.scss';
import { menuItem } from '../../menu_items/sidebar_menu';

const Sidebar = ({ children }) => {
  const open = useSelector(({ layout }) => layout.open);
  // const dispatch = useDispatch();
  // const onSidebarOpen = useCallback(() => dispatch(sidebarOpen()), [dispatch]);

  return (
    <div className={`${open ? '' : styles.collapsed} ${styles.sidebar}`}>
      {/* <button onClick={() => onSidebarOpen()} /> */}
      <div className={styles.menu}>
        {menuItem.manage.map((menu, index) => (
          <div className={styles.navMenu} key={index}>
            <div className={styles.title}>
              {/* <i className={styles.icon}> */}
              {/* <menu.icon /> */}
              <span className="material-icons-outlined">{menu.icon}</span>
              {/* </i> */}
              <div className={styles.navMenuName}>
                <span>
                  <h5>{menu.title}</h5>
                </span>
              </div>
              <span className="material-icons-outlined">expand_more</span>
            </div>

            <div className={styles.items}>
              {menu.items.map((item, index) => (
                <div className={styles.item} key={index}>
                  <h6>{item.name}</h6>
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Sidebar;
