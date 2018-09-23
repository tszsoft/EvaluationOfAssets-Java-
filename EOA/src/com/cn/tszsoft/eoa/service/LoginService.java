/**
 * 
 */
package com.cn.tszsoft.eoa.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.tszsoft.eoa.controller.LoginController;

/**
 * @author liuxiaoliang
 *
 */
@Service("loginService")
public class LoginService implements ILoginService {

//    @Autowired
//    private UserDao userDao;
//
//    public UserDao getUserDao() {
//        return userDao;
//    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Transactional
    public int login(String userid, String password) throws Exception {
//        logger.debug(LbsMessages.PASSWORD_CONFIRM_START);
//
//        int retCode = LbsConstants.RET_CODE_0;
//
//        Users users = new Users();
//
//        if (StringUtils.isEmpty(userid)) {
//            // 用户名为空
//            retCode = LbsConstants.RET_CODE_1;
//        } else if (StringUtils.isEmpty(password)) {
//            // 密码为空
//            retCode = LbsConstants.RET_CODE_2;
//        } else {
//            users = userDao.loadByUserId(userid);
//            // 用户存在判定
//            if (users != null) {
//                // 密码验证
//                if (StringUtils.equals(password, users.getPassword())) {
//                    // 验证成功
//                    retCode = LbsConstants.RET_CODE_0;
//                } else {
//                    // 验证失败
//                    retCode = LbsConstants.RET_CODE_4;
//                }
//            } else {
//                // 用户不存在
//                retCode = LbsConstants.RET_CODE_3;
//            }
//        }
//
//        logger.debug(LbsMessages.PASSWORD_CONFIRM_END);
//        return retCode;
        return 0;
    }
}
