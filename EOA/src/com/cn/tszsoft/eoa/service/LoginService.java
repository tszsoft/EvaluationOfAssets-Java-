/**
 * 
 */
package com.cn.tszsoft.eoa.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.tszsoft.eoa.common.Constants;
import com.cn.tszsoft.eoa.common.Messages;
import com.cn.tszsoft.eoa.controller.LoginController;
import com.cn.tszsoft.eoa.dao.UserDao;
import com.cn.tszsoft.eoa.model.Users;

/**
 * @author liuxiaoliang
 *
 */
@Service("loginService")
public class LoginService implements ILoginService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Transactional
    public int login(String userid, String password) throws Exception {
        logger.debug(Messages.PASSWORD_CONFIRM_START);

        int retCode = Constants.RET_CODE_0;

        Users users = new Users();

        if (StringUtils.isEmpty(userid)) {
            // 用户名为空
            retCode = Constants.RET_CODE_1;
        } else if (StringUtils.isEmpty(password)) {
            // 密码为空
            retCode = Constants.RET_CODE_2;
        } else {
            users = userDao.selectUserByUid(userid);
            // 用户存在判定
            if (users != null) {
                // 密码验证
                if (StringUtils.equals(password, users.getPswd())) {
                    // 验证成功
                    retCode = Constants.RET_CODE_0;
                } else {
                    // 验证失败
                    retCode = Constants.RET_CODE_4;
                }
            } else {
                // 用户不存在
                retCode = Constants.RET_CODE_3;
            }
        }

        logger.debug(Messages.PASSWORD_CONFIRM_END);
        return retCode;
    }
}
