/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {Accordion, List, WingBlank, WhiteSpace,} from 'antd-mobile'

export default function Page1() {
  return <div style={{height: '100%'}}>
    <WingBlank>
      <WhiteSpace/>
      <Accordion defaultActiveKey="0" className="my-accordion">
        <Accordion.Panel header="Title 1">
          <List className="my-list">
            <List.Item>content 1</List.Item>
            <List.Item>content 2</List.Item>
            <List.Item>content 3</List.Item>
          </List>
        </Accordion.Panel>
        <Accordion.Panel header="Title 2" className="pad">this is panel content2 or other</Accordion.Panel>
        <Accordion.Panel header="Title 3" className="pad">
          text text text text text text text text text text text text text text text
        </Accordion.Panel>
      </Accordion>
      <WhiteSpace/>
    </WingBlank>
  </div>
}
