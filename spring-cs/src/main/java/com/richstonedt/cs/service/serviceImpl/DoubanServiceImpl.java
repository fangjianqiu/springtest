package com.richstonedt.cs.service.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.richstonedt.cs.mapper.DoubanMapper;
import com.richstonedt.cs.service.DoubanService;
import com.richstonedt.model.param.DoubanParams;
import com.richstonedt.model.po.Douban;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public List<Douban> listByParams(DoubanParams params){
        Wrapper<Douban> wrapper = buildWrapper(params);
        return baseMapper.selectList(wrapper);
    }


    @Override
    public IPage<Douban> listPageByParams(DoubanParams params){
        Wrapper<Douban> wrapper = buildWrapper(params);
        return baseMapper.selectPage(new Page<>(params.getCurrent(), params.getSize()), wrapper);
    }

    private Wrapper<Douban> buildWrapper(DoubanParams params){
        return Wrappers.<Douban>lambdaQuery()
                .eq(StringUtils.hasText(params.getMovieName()),Douban::getMovieName, params.getMovieName())
                .eq(StringUtils.hasText(params.getRanking()),Douban::getRanking, params.getRanking())
                .orderByDesc(Douban::getScore);
    }
}
