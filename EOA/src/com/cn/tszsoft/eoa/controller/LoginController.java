/**
 * Login
 */
package com.cn.tszsoft.eoa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.tszsoft.eoa.common.Constants;
import com.cn.tszsoft.eoa.common.Messages;
import com.cn.tszsoft.eoa.service.LoginService;

/**
 * @author liuxiaoliang
 */
@Controller
public class LoginController{

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        logger.debug(Messages.PASSWORD_CONFIRM_START);

        Map<String, String> jsonMap = new HashMap<String, String>();
        int retCode = Constants.RET_CODE_0;
        String username = "";

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

System.out.println("userid-----------" + userid);
System.out.println("password---------" + password);
        
        try {
            retCode = loginService.login(userid, password);
            if (retCode != Constants.RET_CODE_0) {
                // 用户名为空
                if (retCode == Constants.RET_CODE_1) {
//                    mav.setViewName("login");
//                    mav.addObject("retCode", Constants.RET_CODE_1);
//                    mav.addObject("message", "用户名不能为空");
                    jsonMap.put("retCode", "1");
                    jsonMap.put("message", "用户名不能为空");
                } else
                // 密码为空
                if (retCode == Constants.RET_CODE_2) {
//                    mav.setViewName("login");
//                    mav.addObject("retCode", Constants.RET_CODE_2);
//                    mav.addObject("message", "密码不能为空");
                    jsonMap.put("retCode", "2");
                    jsonMap.put("message", "密码不能为空");
                } else
                // 用户不存在
                if (retCode == Constants.RET_CODE_3) {
//                    mav.setViewName("login");
//                    mav.addObject("retCode", Constants.RET_CODE_3);
//                    mav.addObject("message", "该用户不存在");
                    jsonMap.put("retCode", "3");
                    jsonMap.put("message", "该用户不存在");
                } else
                // 验证失败
                if (retCode == Constants.RET_CODE_4) {
//                    mav.setViewName("login");
//                    mav.addObject("retCode", Constants.RET_CODE_4);
//                    mav.addObject("message", "密码错误");
                    jsonMap.put("retCode", "4");
                    jsonMap.put("message", "密码错误");
                }
            } else {
                // 验证成功
                session.setAttribute("userid", userid);
                session.setAttribute("username", username);
//                mav.setViewName("loginSuccess");
//                mav.addObject("message", "( " + userid + " ) 登录成功");
                jsonMap.put("retCode", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
//            mav.setViewName("ErrorPage");
//            mav.addObject("message", e.getMessage());
//            return "error";
        }
        
        try {
            String result = JSONObject.toJSONString(jsonMap);
            System.out.println(result);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(result);
            logger.debug(Messages.PASSWORD_CONFIRM_END);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        return "success";
    }

}
