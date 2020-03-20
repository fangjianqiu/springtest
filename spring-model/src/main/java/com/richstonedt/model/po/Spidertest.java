package com.richstonedt.model.po;


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
public class Spidertest implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String adcode;

    private String weatherName;

}
