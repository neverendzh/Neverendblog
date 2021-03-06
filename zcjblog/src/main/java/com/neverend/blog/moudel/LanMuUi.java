package com.neverend.blog.moudel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zcg
 */
@ApiModel(value="导航栏标题", description="导航栏标题内容信息")
public class LanMuUi implements Serializable {
    @JsonIgnore
    private String superName;

    @ApiModelProperty(value = "栏目名称")
    private String lanMu;

    @ApiModelProperty("栏目的权限Code，根据当前用户的角色，加载权限菜单，菜单权限中有对应的url，如果当前用户没有所属的Code则没有对应权限")
    private String roleCode;
    @ApiModelProperty("访问栏目的url")
    private String lookUrl;
    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "LanMuUi{" +
                "superName='" + superName + '\'' +
                ", lanMu='" + lanMu + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", lookUrl='" + lookUrl + '\'' +
                '}';
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getLanMu() {
        return lanMu;
    }

    public void setLanMu(String lanMu) {
        this.lanMu = lanMu;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getLookUrl() {
        return lookUrl;
    }

    public void setLookUrl(String lookUrl) {
        this.lookUrl = lookUrl;
    }
}
