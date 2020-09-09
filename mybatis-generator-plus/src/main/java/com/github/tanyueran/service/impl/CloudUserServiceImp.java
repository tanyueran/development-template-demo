package com.github.tanyueran.service.impl;

import com.github.tanyueran.entity.CloudUser;
import com.github.tanyueran.mapper.CloudUserMapper;
import com.github.tanyueran.service.CloudUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author tanxin
 * @since 2020-09-09
 */
@Service
public class CloudUserServiceImp extends ServiceImpl<CloudUserMapper, CloudUser> implements CloudUserService {

}
