package com.kulu.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 菜單表(Menu)實體類
 * 
 * @author user
 */
@TableName(value = "sys_menu")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {
	private static final long serialVersionUID = -54979041104113736L;
	
	@TableId
	private Long id;
	/**
	 * 菜單名
	 */
	private String menuName;
	/**
	 * 路由地址
	 */
	private String path;
	/**
	 * 組件路徑
	 */
	private String component;
	/**
	 * 菜單狀態(0.顯示，1.隱藏)
	 */
	private String visible;
	/**
	 * 菜單狀態(0.正常，1.停用)
	 */
	private String status;
	/**
	 * 權限標識
	 */
	private String perms;
	/**
	 * 菜單圖標
	 */
	private String icon;

	private Long createBy;

	private Date createTime;

	private Long updateBy;

	private Date updateTime;
	/**
	 * 是否刪除(0.未刪除，1.已刪除)
	 */
	private Integer del_flag;
	/**
	 * 備註
	 */
	private String remark;
	
	
	public Menu() {
//		super();
	}

	public Menu(Long id, String menuName, String path, String component, String visible, String status, String perms,
			String icon, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer del_flag,
			String remark) {
//		super();
		this.id = id;
		this.menuName = menuName;
		this.path = path;
		this.component = component;
		this.visible = visible;
		this.status = status;
		this.perms = perms;
		this.icon = icon;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.del_flag = del_flag;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", path=" + path + ", component=" + component
				+ ", visible=" + visible + ", status=" + status + ", perms=" + perms + ", icon=" + icon + ", createBy="
				+ createBy + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime
				+ ", del_flag=" + del_flag + ", remark=" + remark + "]";
	}
}
