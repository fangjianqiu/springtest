package com.richstonedt.common.util;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * <b><code>ExcelUtils</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/1/7 18:53.
 *
 * @author Li Shangzhe
 * @since czps2s4ada-sal-be 0.2.0
 */
public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static <T> String exportToExcel(List<T> list, Class<T> cls) {
        if (TempFileUtils.tempDirNotExists()) {
            TempFileUtils.createTempDir();
        }
        String fileName = String.valueOf(System.currentTimeMillis()).concat(".xlsx");
        String path = TempFileUtils.TEMP_DIR + fileName;
        EasyExcel.write(path, cls).sheet().doWrite(list);
        return fileName;
    }
}
