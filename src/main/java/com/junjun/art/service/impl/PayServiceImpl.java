package com.junjun.art.service.impl;

import com.junjun.art.pojo.Pay;
import com.junjun.art.mapper.PayMapper;
import com.junjun.art.service.PayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author junjun
 * @since 2019-07-18
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {

}
