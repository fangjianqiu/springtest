package com.richstonedt.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * <b><code>ResponseResult</code></b>
 * <p>
 * API请求返回实体类
 * <p>
 * <b>Creation Time:</b> 2019年5月24日 下午3:54:03
 * @param <T> 返回数据泛型
 * @author Wu Junbiao
 * @version Revision 2019年5月24日
 * @since czps2s4ada-sal-be 0.1.0
 */
@Getter
@ToString
@ApiModel(value = "通用请求返回实体类", description = "通用请求返回实体类")
public final class ResponseResult<T> implements CommonResult {

	/**
	 * 表示接口调用状态，“ 200”表示成功；
	 *
	 * @since its-ms-core project_version
	 */
	@ApiModelProperty("请求结果系统内部状态")
	private int code;
	/**
	 * 接口调用状态说明，可空。
	 *
	 * @since its-ms-core project_version
	 */
	@ApiModelProperty("请求结果描述")
	private String msg;
	/**
	 * 请求返回的具体数据。
	 *
	 * @since its-ms-core project_version
	 */
	@ApiModelProperty("请求结果返回的数据")
	private T data;

	/**
	 * 判断请求是否成功
	 *
	 * @return 如果状态值在200 - 299 之间，返回true，否则返回false
	 * @since its-ms-core project_version
	 */
	@JsonIgnore
	@Override
	public boolean isSuccess() {
		HttpStatus status = HttpStatus.valueOf(this.code);
		return status.is2xxSuccessful();
	}

	/**
	 * 构造成功请求的返回body，状态码：200
	 *
	 * @return
	 * @since its-ms-core project_version
	 */
	public static <T> ResponseResult<T> success() {
		return new ResponseResult<>(HttpStatus.OK);
	}

	/**
	 * 构造成功请求的返回body，状态码：200
	 *
	 * @param data 返回数据
	 * @return
	 * @since its-ms-core project_version
	 */
	public static <T> ResponseResult<T> success(T data) {
		return ResponseResult.success(HttpStatus.OK, data);
	}

	/**
	 * 构造成功请求的返回body，状态码：200-299
	 *
	 * @param status
	 * @return
	 * @since its-ms-core project_version
	 */
	public static <T> ResponseResult<T> success(HttpStatus status) {
		return ResponseResult.success(status, null);
	}

	/**
	 * 构造成功请求的返回body，状态码：200-299
	 *
	 * @param status HttpStatus
	 * @param data 返回数据
	 * @return
	 * @since its-ms-core project_version
	 */
	public static <T> ResponseResult<T> success(HttpStatus status, T data) {
		if (!status.is2xxSuccessful()) {
			throw new IllegalArgumentException("Error response status should be 2XX status.");
		}
		return new ResponseResult<>(status, data);
	}

	/**
	 * 构造失败请求的返回body，状态码：除200-299以外的HttpStatus code
	 *
	 * @param status
	 *            HttpStatus
	 * @return
	 * @since its-ms-core project_version
	 */
	public static <T> ResponseResult<T> error(HttpStatus status) {
		return ResponseResult.error(status, null);
	}

	/**
	 * 构造失败请求的返回body，状态码：除200-299以外的HttpStatus code
	 *
	 * @param status
	 *            HttpStatus
	 * @param data
	 *            返回数据
	 * @return
	 * @since its-ms-core project_version
     */
    public static <T> ResponseResult<T> error(HttpStatus status, T data) {
        if (status.is2xxSuccessful()) {
            throw new IllegalArgumentException("Error response status should not be 2XX status.");
        }
        return new ResponseResult<>(status, data);
    }

    public static <T> ResponseResult<T> error(HttpStatus status, String msg, T data) {
        if (status.is2xxSuccessful()) {
            throw new IllegalArgumentException("Error response status should not be 2XX status.");
        }
        return new ResponseResult<>(status.value(), msg, data);
    }

    public static <T> ResponseResult<T> error(HttpStatus status, String msg) {
        if (status.is2xxSuccessful()) {
            throw new IllegalArgumentException("Error response status should not be 2XX status.");
        }
        return new ResponseResult<>(status.value(), msg, null);
    }

    private ResponseResult(HttpStatus status) {
        this(status, null);
    }

    private ResponseResult(HttpStatus status, T data) {
		this(status.value(), status.getReasonPhrase(), data);
	}

	private ResponseResult() {
	}

	private ResponseResult(int state, String msg, T data) {
		super();
		this.code = state;
		this.msg = msg;
		this.data = data;
	}
}