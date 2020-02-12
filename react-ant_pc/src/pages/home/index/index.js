/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {
  Row,
  Col,
  Card,
} from "antd";

import './index.scss'

export default function Page1() {
  return <div className={"home-page-container"}>
    <Row gutter={16}>
      <Col span={8}>
        <Card title="Card title" bordered={false}>
          Card content
        </Card>
      </Col>
      <Col span={8}>
        <Card title="Card title" bordered={false}>
          Card content
        </Card>
      </Col>
      <Col span={8}>
        <Card title="Card title" bordered={false}>
          Card content
        </Card>
      </Col>
    </Row>
  </div>
}
