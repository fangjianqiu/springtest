package com.richstonedt.common.util;

import java.util.UUID;

/**
 * <b><code>IdGeneratorUtils</code></b>
 * <p/>
 * GUID 生成工具类
 * <p/>
 * <b>Creation Time:</b> 2019/11/15 18:30.
 *
 * @author Li Shangzhe
 * @since czps-sal-be 0.1.0
 */
public final class IdUtils {

    private IdUtils() {
    }

    /**
     * 生成
     *
     * @return 生成的UUID
     */
    public static String generate() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
