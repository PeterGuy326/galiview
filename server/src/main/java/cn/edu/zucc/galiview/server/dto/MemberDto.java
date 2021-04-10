package cn.edu.zucc.galiview.server.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberDto {

    /**
    * id
    */
    private String id;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String name;

    /**
    * 头像url
    */
    private String photo;

    /**
    * 注册时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mobile=").append(mobile);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", photo=").append(photo);
        sb.append(", registerTime=").append(registerTime);
        sb.append("]");
        return sb.toString();
    }

}