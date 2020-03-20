package com.richstonedt.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b><code>StateEnum</code></b>
 * <p/>
 * Description 标准数据状态枚举
 * <p/>
 * <b>Creation Time:</b> 2019/12/23 14:18.
 *
 * @author Wu Junbiao
 * @version 1.0.0
 * @since czps2s4ada-sdl-be 0.1.0
 */
@Getter
@AllArgsConstructor
public enum DeletedFlagEnum {
    /**
     * 0未删除
     */
    ZERO((byte) 0),
    /**
     * 1已删除
     */
    ONE((byte) 1);


    byte value;
}
