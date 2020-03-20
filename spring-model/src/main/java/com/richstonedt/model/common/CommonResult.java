package com.richstonedt.model.common;

/**
 * <b><code>CommonResult</code></b>
 * <p>
 * Web返回实体通用接口，用于对接不同系统时候，实体类不同的情况。
 * <p>
 * <b>Creation Time:</b> 2019年6月18日 下午12:07:59
 * @author Zhong Dayang
 * @version Revision 2019年6月18日
 *  @since czps2s4ada-sal-be 0.1.0
 */
public interface CommonResult {
	/**
	 * 请求是否成功
	 * <p>
	 * 交由各个子类去实现
	 * @return 成功返回true，失败返回false
	 * @since its-ms-core project_version
	 */
	boolean isSuccess();
}
