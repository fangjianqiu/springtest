package com.richstonedt.cs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <b><code>BaseService</code></b>
 * <p/>
 * Description 公共Service层
 * <p/>
 * <b>Creation Time:</b> 2019/12/24 14:21.
 *
 * @author Wu Junbiao
 * @version 1.0.0
 * @since czps2s4ada-sdl-be 0.1.0
 */
public interface BaseService<T,K> {
    /**
     * 按条件查询所有信息
     * @param params 查询条件
     * @return 查询结果集
     */
    List<T> listByParams(K params);

    /**
     * 按条件查询信息，支持分页
     * @param params 查询条件
     * @return 查询结果分页集
     */
    IPage<T> listPageByParams(K params);
}
