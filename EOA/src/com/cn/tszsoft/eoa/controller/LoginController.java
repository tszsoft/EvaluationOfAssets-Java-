/**
 * Login
 */
package com.cn.tszsoft.eoa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cn.tszsoft.eoa.common.*;
import com.cn.tszsoft.eoa.service.LoginService;

/**
 * @author liuxiaoliang
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession session;

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		logger.debug(Messages.PASSWORD_CONFIRM_START);

		ModelAndView mav = new ModelAndView();
		int retCode = Constants.RET_CODE_0;

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		try {
			retCode = loginService.login(userid, password);
			if (retCode != Constants.RET_CODE_0) {
				// 用户名为空
				if (retCode == Constants.RET_CODE_1) {
					mav.setViewName("loginError");
					mav.addObject("message", "( " + userid + " ) 用户名为空！");
				} else
				// 密码为空
				if (retCode == Constants.RET_CODE_2) {
					mav.setViewName("loginError");
					mav.addObject("message", "( " + userid + " ) 密码为空！");
				} else
				// 用户不存在
				if (retCode == Constants.RET_CODE_3) {
					mav.setViewName("loginError");
					mav.addObject("message", "( " + userid + " ) 用户不存在！");
				} else
				// 验证失败
				if (retCode == Constants.RET_CODE_4) {
					mav.setViewName("loginError");
					mav.addObject("message", "( " + userid + " ) 密码错误！");
				}
			} else {
				// 验证成功
				session.setAttribute("userid", userid);
				mav.setViewName("loginSuccess");
				mav.addObject("message", "( " + userid + " ) 登录成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("ErrorPage");
			mav.addObject("message", e.getMessage());
			return mav;
		}

		logger.debug(Messages.PASSWORD_CONFIRM_END);
		return mav;
	}

}
