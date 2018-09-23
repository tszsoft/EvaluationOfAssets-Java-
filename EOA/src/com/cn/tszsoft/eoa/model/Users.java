package com.cn.tszsoft.eoa.model;

import java.util.Date;

public class Users {

    private Long id;

    private String uid;

    private String pswd;

    private String name;

    private String job_post;
    
    private boolean del_flg;
    
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_post() {
        return job_post;
    }

    public void setJob_post(String job_post) {
        this.job_post = job_post;
    }

    public boolean isDel_flg() {
        return del_flg;
    }

    public void setDel_flg(boolean del_flg) {
        this.del_flg = del_flg;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
