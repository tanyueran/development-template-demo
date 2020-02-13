import React, {Suspense} from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';
import {Affix} from 'antd';
import routes from './router/index.js'

import MLoading from './components/MLoading.js'

function App() {
  return (
    <>
      <Suspense fallback={<MLoading/>}>
        <Router>
          <Switch>
            {
              routes.map((route, i) => <Route exact={route.exact} key={i} path={route.path} render={
                  props =>
                    <route.component {...props} routes={route.children}/>}
                />
              )
            }
            <Affix>123</Affix>
          </Switch>
        </Router>
      </Suspense>
    </>
  );
}

export default App;
