package com.richstonedt.common.util;


import com.richstonedt.common.enums.DeletedFlagEnum;
import com.richstonedt.common.enums.StateEnum;
import com.richstonedt.model.po.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * <b><code>EntityUtils</code></b>
 * <p/>
 * Description 公共包装实体属性类
 * <p/>
 * <b>Creation Time:</b> 2019/12/26 10:27.
 *
 * @author Wu Junbiao
 * @version 1.0.0
 * @since czps2s4ada-sdl-be 0.1.0
 */
public class EntityUtils {

    /**
     * 新增数据的公共属性设置
     *
     * @param entity 新增的数据实体
     * @param <T>    泛型类
     * @return 重新增加id，state，deleteFlag，createdTime属性的实体
     */
    public static <T extends BaseEntity> T insertEntityWrapper(T entity) {
//        entity.setId(IdUtils.generate());
//        entity.setState(StateEnum.ONE.getState());
//        entity.setDeletedFlag(DeletedFlagEnum.ZERO.getValue());
//        entity.setCreatedTime(new Date());
        entity.setRanking(entity.getRanking());
        entity.setMovieName(entity.getMovieName());
        entity.setQuote(entity.getQuote());
        entity.setScore(entity.getScore());
        entity.setScoreNum(entity.getScoreNum());
        return entity;
    }

    /**
     * 批量新增数据的公共属性设置
     *
     * @param entityList 新增的数据实体集合
     * @param <T>        泛型类
     * @return 重新增加id，state，deleteFlag，createdTime属性的实体
     */
    public static <T extends BaseEntity> List<T> insertBatchEntityWrapper(List<T> entityList) {
        for (T entity : entityList) {
            insertEntityWrapper(entity);
        }
        return entityList;
    }

    /**
     * 更新数据的公共属性设置
     *
     * @param entity 更新的数据实体
     * @param <T>    泛型类
     * @return 增加的实体updatedTime
     */
    public static <T extends BaseEntity> T updateEntityWrapper(T entity) {
//        entity.setUpdatedTime(new Date());
        return entity;
    }

    /**
     * 批量更新数据的公共属性设置
     *
     * @param entityList 更新的数据实体集合
     * @param <T>        泛型类
     * @return 增加的实体updatedTime
     */
    public static <T extends BaseEntity> List<T> updateBatchEntityWrapper(List<T> entityList) {
        for (T entity : entityList) {
            updateEntityWrapper(entity);
        }
        return entityList;
    }
}
