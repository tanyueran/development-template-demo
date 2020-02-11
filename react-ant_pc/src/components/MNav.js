/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {withRouter} from 'react-router-dom'


class MNav extends React.Component {

  barClickHandler(event, item, i) {
    this.props.history.replace(item.path);
  }

  render() {
    return <footer className={this.props.className} style={this.props.style}>
    </footer>
  }

}

export default withRouter(MNav);
