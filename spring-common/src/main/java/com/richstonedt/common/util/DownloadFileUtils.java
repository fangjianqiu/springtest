package com.richstonedt.common.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * <b><code>DownloadFileUtils</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/1/14 16:33.
 *
 * @author Li Shangzhe
 * @since czps2s4ada-sal-be 0.2.0
 */
public final class DownloadFileUtils {

    private DownloadFileUtils() {

    }

    public static ResponseEntity<InputStreamResource> fileToStream(String fileName, String prefix) throws IOException {
        FileSystemResource file = new FileSystemResource(TempFileUtils.TEMP_DIR + fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + URLEncoder.encode(prefix + "-" + fileName, "UTF-8"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
