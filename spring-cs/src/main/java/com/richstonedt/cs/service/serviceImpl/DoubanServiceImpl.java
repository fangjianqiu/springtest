package com.richstonedt.cs.service.serviceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richstonedt.cs.mapper.DoubanMapper;
import com.richstonedt.cs.service.DoubanService;
import com.richstonedt.model.po.Douban;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cheng
 * @since 2020-03-16
 */
@Service
public class DoubanServiceImpl extends ServiceImpl<DoubanMapper, Douban> implements DoubanService {
}
