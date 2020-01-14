import React, {Suspense} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import routes from './router/index.js'

import MLoading from './components/MLoading.js'


function App() {
  return (
    <div className="app" style={{height: '100%'}}>
      <Suspense fallback={<MLoading/>}>
        <Router>
          <Switch>
            {
              routes.map((route, i) =>
                <Route exact={route.exact} key={i} path={route.path} render={
                  props =>
                    <route.component {...props} routes={route.children}/>}
                />
              )
            }
          </Switch>
        </Router>
      </Suspense>
    </div>
  );
}

export default App;
