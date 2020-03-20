package com.richstonedt.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cheng
 * @since 2020-03-16
 */
@Data
@TableName("douban")
public class Douban extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private String ranking;

    private String movieName;

    private String score;

    private String scoreNum;

    private String quote;

    private Byte deleted;
}
