import { createStore, applyMiddleware } from 'redux';
import rootReducer from './reducer';
import ReduxThunk from 'redux-thunk';
import { createLogger } from 'redux-logger';
import { composeWithDevTools } from 'redux-devtools-extension';

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(ReduxThunk, createLogger()))
);

export default store;
