package com.neverend.blog.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class LanMu implements Serializable {
    /**
     * 主键
     */
    private String yiJiLanMuId;

    /**
     * 菜单名称
     */
    private String lanMuName;

    /**
     * 栏目属于顶部还是尾部，对应SuperLanMu中的主键
     */
    private String superLanMuId;

    /**
     * 对应RolePermission中的主键，关联权限id
     */
    private String rolePermissionId;

    /**
     * 作为url参数表示一个唯一的菜单
     */
    private String beiYongYi;

    /**
     * 栏目状态是否禁用 true禁用，false不禁用
     */
    private String beiYongEr;

    private String beiYongSan;

    private String beiYongSi;

    private String beiYongWu;

    @Override
    public String toString() {
        return "LanMu{" +
                "yiJiLanMuId='" + yiJiLanMuId + '\'' +
                ", lanMuName='" + lanMuName + '\'' +
                ", superLanMuId='" + superLanMuId + '\'' +
                ", rolePermissionId='" + rolePermissionId + '\'' +
                ", beiYongYi='" + beiYongYi + '\'' +
                ", beiYongEr='" + beiYongEr + '\'' +
                ", beiYongSan='" + beiYongSan + '\'' +
                ", beiYongSi='" + beiYongSi + '\'' +
                ", beiYongWu='" + beiYongWu + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;

    public String getYiJiLanMuId() {
        return yiJiLanMuId;
    }

    public void setYiJiLanMuId(String yiJiLanMuId) {
        this.yiJiLanMuId = yiJiLanMuId;
    }

    public String getLanMuName() {
        return lanMuName;
    }

    public void setLanMuName(String lanMuName) {
        this.lanMuName = lanMuName;
    }

    public String getSuperLanMuId() {
        return superLanMuId;
    }

    public void setSuperLanMuId(String superLanMuId) {
        this.superLanMuId = superLanMuId;
    }

    public String getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public String getBeiYongYi() {
        return beiYongYi;
    }

    public void setBeiYongYi(String beiYongYi) {
        this.beiYongYi = beiYongYi;
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
}