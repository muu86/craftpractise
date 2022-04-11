const SIDEBAR_OPEN = 'layout/SIDEBAR_OPEN';

export const sidebarOpen = () => ({
  type: SIDEBAR_OPEN,
});

const initialState = {
  open: true,
};

const layout = (state = initialState, action) => {
  switch (action.type) {
    case SIDEBAR_OPEN:
      return {
        open: !state.open,
      };
    default:
      return state;
  }
};

export default layout;
