package com.cn.tszsoft.eoa.dao;

import com.cn.tszsoft.eoa.model.Users;

public class UserDao implements IUserDao {

    public Users selectUserByUid(String uid) throws Exception {
        Users result = new Users();
        
        result.setUid("admin");
        result.setPswd("1");
        result.setName("Jack");
        
        return result;
    }

}
