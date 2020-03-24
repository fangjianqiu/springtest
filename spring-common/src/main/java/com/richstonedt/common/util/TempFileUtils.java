package com.richstonedt.common.util;

import java.io.File;

/**
 * <b><code>TempFileUtils</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/11/28 18:55.
 *
 * @author Li Shangzhe
 * @since czps-sal-be 0.1.0
 */
public final class TempFileUtils {

    public static final String TEMP_DIR = "/tmp/sal/";

    private TempFileUtils() {
    }

    public static boolean tempDirNotExists() {
        File file = new File(TEMP_DIR);
        return !file.exists() || !file.isDirectory();
    }

    public static void createTempDir() {
        File file = new File(TEMP_DIR);
        boolean success = file.mkdirs();
        if (!success) {
            throw new RuntimeException("创建临时文件夹错误");
        }
    }
}
