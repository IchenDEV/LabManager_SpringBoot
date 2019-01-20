package com.idevlab.LabMgr.Config.Shiro;

import com.alibaba.fastjson.JSONObject;
import com.idevlab.LabMgr.Util.Constants.ErrorEnum;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: idevlab
 * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 * @date: 2017/10/24 10:11
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
		if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {

			HttpServletResponse res = (HttpServletResponse) response;
			PrintWriter out = null;
			try {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("application/json");
				res.setHeader("Access-Control-Allow-Origin",((HttpServletRequest) request).getHeader("Origin") );
				res.setHeader("Access-Control-Allow-Credentials", "true");
				res.setHeader("Access-Control-Allow-Headers",
						"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,XX-Token,XX-Device-Type,sessionID");
				out = response.getWriter();
			} catch (Exception e) {
			} finally {
				if (null != out) {
					out.flush();
					out.close();
				}
			}

		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("code", ErrorEnum.E_20011.getErrorCode());
			jsonObject.put("msg", ErrorEnum.E_20011.getErrorMsg());
			PrintWriter out = null;
			HttpServletResponse res = (HttpServletResponse) response;
			try {
				res.setCharacterEncoding("UTF-8");
				res.setContentType("application/json");
				out = response.getWriter();
				out.println(jsonObject);
			} catch (Exception e) {
			} finally {
				if (null != out) {
					out.flush();
					out.close();
				}
			}
		}
		return false;
	}

	@Bean
	public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
		registration.setEnabled(false);
		return registration;
	}
}