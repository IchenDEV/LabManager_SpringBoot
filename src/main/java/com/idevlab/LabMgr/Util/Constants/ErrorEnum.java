package com.idevlab.LabMgr.Util.Constants;

public enum ErrorEnum {

	/*
	 * 错误信息
	 */
	E_400("400", "Bad Request"), E_500("500", "请求方式有误,请检查 GET/POST"), E_404("404", "Not Found"), E_501("501", "请求路径不存在"),
	E_502("502", "权限不足"), E_10008("10008", "角色删除失败,尚有用户属于此角色"), E_10009("10009", "账户名存在"),
	E_20011("20011", "登陆已过期,请重新登陆"), E_90003("90003", "缺少必填参数"), E_90004("90004", "时间冲突");

	private String errorCode;
	private String errorMsg;

	ErrorEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	// #region getter setter
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	// #endregion

}