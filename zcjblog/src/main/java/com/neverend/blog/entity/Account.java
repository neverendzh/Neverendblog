package com.neverend.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@ApiModel(value="用户信息", description="返回登陆用户信息")
public class Account implements Serializable {
    public static final String STATE_NORMAL = "正常";
    public static final String STATE_DISABLE = "禁用";
    public static final String STATE_LOCKED = "锁定";
    /**
     * 主键
     */
    @ApiModelProperty(value="用户唯一id")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String userPassword;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String userEmail;

    /**
     * 手机
     */
    @ApiModelProperty(value="手机")
    private String cellphoneNumber;

    /**
     * 文章
     */
    @JsonIgnore
    private String articleId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date creatTime;

    /**
     * 最近跟新资料时间
     */
    @ApiModelProperty(value="最近跟新资料时间")
    private Date loginEndTime;

    /**
     * 账号状态：正常禁用锁定
     */
    @ApiModelProperty(value="账号状态：正常禁用锁定")
    private String accountState;

    /**
     * 用户角色名称
     */
    @ApiModelProperty(value="用户角色名称")
    private String beiYongEr;

    /**
     * 头像地址 url
     */
    @ApiModelProperty(value="头像地址 url")
    private String beiYongSan;

    /**
     * 性别 1 男 2女
     */
    @ApiModelProperty(value="性别1 男 2女")
    private String beiYongSi;
    /**
     * 头像文件名
     */
    @ApiModelProperty(value="头像文件名")
    private String beiYongWu;
    @JsonIgnore
    private String beiYongLiu;
    @JsonIgnore
    private String beiYongQi;
    @JsonIgnore
    private String beiYongBa;
    @JsonIgnore
    private String rolesName;
    private static final long serialVersionUID = 1L;

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLoginEndTime() {
        return loginEndTime;
    }

    public void setLoginEndTime(Date loginEndTime) {
        this.loginEndTime = loginEndTime;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public String getBeiYongEr() {
        return beiYongEr;
    }

    public void setBeiYongEr(String beiYongEr) {
        this.beiYongEr = beiYongEr;
    }

    public String getBeiYongSan() {
        return beiYongSan;
    }

    public void setBeiYongSan(String beiYongSan) {
        this.beiYongSan = beiYongSan;
    }

    public String getBeiYongSi() {
        return beiYongSi;
    }

    public void setBeiYongSi(String beiYongSi) {
        this.beiYongSi = beiYongSi;
    }

    public String getBeiYongWu() {
        return beiYongWu;
    }

    public void setBeiYongWu(String beiYongWu) {
        this.beiYongWu = beiYongWu;
    }

    public String getBeiYongLiu() {
        return beiYongLiu;
    }

    public void setBeiYongLiu(String beiYongLiu) {
        this.beiYongLiu = beiYongLiu;
    }

    public String getBeiYongQi() {
        return beiYongQi;
    }

    public void setBeiYongQi(String beiYongQi) {
        this.beiYongQi = beiYongQi;
    }

    public String getBeiYongBa() {
        return beiYongBa;
    }

    public void setBeiYongBa(String beiYongBa) {
        this.beiYongBa = beiYongBa;
    }
}