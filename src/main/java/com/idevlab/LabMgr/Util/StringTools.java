package com.idevlab.LabMgr.Util;
/**
 * @author idevlab
 * @description 字符串工具
 */
public class StringTools {
	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) || "null".equals(str);
    }
	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj);
	}
}