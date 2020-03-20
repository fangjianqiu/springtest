package com.richstonedt.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <b><code>BasePageParams</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/12/26 11:00.
 *
 * @author Wu Junbiao
 * @version 1.0.0
 * @since czps2s4ada-sdl-be 0.1.0
 */
@Data
@ApiModel("基础分页")
public class BasePageParams {

    @ApiModelProperty(value = "当前页", example = "1")
    private Integer current = 1;

    @ApiModelProperty(value = "每页大小", example = "10")
    private Integer size = 10;
}
