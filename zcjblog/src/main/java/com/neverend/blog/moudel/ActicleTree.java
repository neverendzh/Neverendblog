package com.neverend.blog.moudel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
@ApiModel(value="树形插件所使用的数据", description="json格式树形插件所使用的数据")
public class ActicleTree {

    @ApiModelProperty(value = "节点标题")
    private String title;  //节点标题

    @ApiModelProperty(value = "节点唯一索引，用于对指定节点进行各类操作")
    private String id;     //节点唯一索引，用于对指定节点进行各类操作

    @ApiModelProperty(value = "子节点和兄弟节点")
    private List<ActicleTree> children; //子节点。支持设定选项同父节点

    @JsonIgnore
    private String href;      //点击节点弹出新窗口对应的 url。

    @ApiModelProperty(value = "节点是否初始展开，默认 false")
    private Boolean spread;//节点是否初始展开，默认 false

    @ApiModelProperty(value = "节点是否初始为选中状态（如果开启复选框的话），默认 false")
    private Boolean checked;//节点是否初始为选中状态（如果开启复选框的话），默认 false

    @ApiModelProperty(value = "节点是否为禁用状态。默认 false")
    private Boolean disabled;//节点是否为禁用状态。默认 false

    @Override
    public String toString() {
        return "ActicleTree{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", children=" + children +
                ", href='" + href + '\'' +
                ", spread=" + spread +
                ", checked=" + checked +
                ", disabled=" + disabled +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ActicleTree> getChildren() {
        return children;
    }

    public void setChildren(List<ActicleTree> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
