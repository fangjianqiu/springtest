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
public enum StateEnum {
    /**
     * 注销
     */
    ZERO((byte) 0),
    /**
     * 正常数据
     */
    ONE((byte) 1),
    /**
     * 变更中
     */
    TWO((byte) 2);

    byte state;
}
