package com.richstonedt.model.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Data
public class DoubanParams extends BasePageParams implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("电影名称")
    private String movieName;

    @ApiModelProperty("排名")
    private String ranking;
}
