package com.richstonedt.model.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * <b><code>BaseEntity</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/12/26 10:39.
 *
 * @author Wu Junbiao
 * @version 1.0.0
 * @since czps2s4ada-sdl-be 0.1.0
 */
@Data
public class BaseEntity {
//    /**
//     * 主键ID,UUID
//     */
//    private String id;
//
//    /**
//     * 记录状态,0注销,1正常,2变更中
//     */
//    private Byte state;
//
//    /**
//     * 删除状态,0未删除,1已删除
//     */
//    @TableLogic
//    private Byte deletedFlag;
//
//    /**
//     * 表记录创建时间
//     */
//    private Date createdTime;
//
//    /**
//     * 表记录更新时间
//     */
//    private Date updatedTime;

    private String ranking;

    private String movieName;

    private String score;

    private String scoreNum;

    private String quote;

}
