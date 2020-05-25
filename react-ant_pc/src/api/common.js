import request from "../utils/request";

/**
 * @author tanxin
 * @date $
 * @Description: 公用模块的请求api
 */
const api = {
  getPrimaryKey: '/red/common/id',
};

// 获取id
export async function getPrimaryKey(num) {
  return request({
    method: 'get',
    url: api.getPrimaryKey + '/' + num,
  });
}
