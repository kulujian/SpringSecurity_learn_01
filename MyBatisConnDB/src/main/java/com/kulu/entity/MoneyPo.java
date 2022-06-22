package com.kulu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

/**
 * Created by @author kulu in 14:25 22/6/21.
 */

@TableName(value = "money")
public class MoneyPo {
    /**
     * 指定自增策略
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Long money;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField(value = "create_at")
    private Timestamp createAt;

    @TableField(value = "update_at")
    private Timestamp updateAt;

    
    
    
	public MoneyPo() {
//		super();
	}

	public MoneyPo(Integer id, String name, Long money, Integer isDeleted, Timestamp createAt, Timestamp updateAt) {
//		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.isDeleted = isDeleted;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "MoneyPo [id=" + id + ", name=" + name + ", money=" + money + ", isDeleted=" + isDeleted + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}
    
    

}