package com.cn.tszsoft.eoa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @RequestMapping("/view")
    public ModelAndView view(HttpServletRequest request) {
        String path = request.getParameter("path") + "";
        ModelAndView mav = new ModelAndView();
        mav.setViewName(path);

        // 获取项目根路径
        String contextPath = request.getContextPath();
        mav.addObject("contextPath", contextPath);

        return mav;
    }
    
}
