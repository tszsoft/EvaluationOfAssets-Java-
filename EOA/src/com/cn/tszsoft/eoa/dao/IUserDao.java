package com.cn.tszsoft.eoa.dao;

import com.cn.tszsoft.eoa.model.Users;

public interface IUserDao {

    public Users selectUserByUid(String uid) throws Exception;

}
