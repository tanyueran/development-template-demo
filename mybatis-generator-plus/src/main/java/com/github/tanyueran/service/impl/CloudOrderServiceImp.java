package com.github.tanyueran.service.impl;

import com.github.tanyueran.entity.CloudOrder;
import com.github.tanyueran.mapper.CloudOrderMapper;
import com.github.tanyueran.service.CloudOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author tanxin
 * @since 2020-09-08
 */
@Service
public class CloudOrderServiceImp extends ServiceImpl<CloudOrderMapper, CloudOrder> implements CloudOrderService {

}
