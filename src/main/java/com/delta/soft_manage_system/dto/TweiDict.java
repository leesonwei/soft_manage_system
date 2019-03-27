package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_DICT
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_dict")
public class TweiDict implements Serializable {
	/***/
	@NullRule(name="數據字典類型")
	private String typeId; 
	/***/
	@TableId
	@Check(id=true,type= CheckId.INPUT,action = {ActionType.UPDATE,ActionType.DELETE})
	private String dictId; 
	/***/
	@NullRule(name="數據字典名稱")
	private String dictName; 
	/***/
	private String dictShortName; 
	/***/
	private String dictFullName; 
	/***/
	private String createBy; 
	/***/
	private Date createAt;
	/***/
	private String updateBy; 
	/***/
	private Date updateAt;
	/***/
	private Integer flag;
	/***/
	private String checkBy; 
	/***/
	private Date checkAt;
	/***/
	private Integer isUsed; 
	/***/
	private String memo;
	/***/
	private String pycode;
	/***/
	@DataVersion
	private Integer dataVersion;

	@Override
	public String toString() {
		return "TweiDict{" +
				"typeId='" + typeId + '\'' +
				", dictId='" + dictId + '\'' +
				", dictName='" + dictName + '\'' +
				", dictShortName='" + dictShortName + '\'' +
				", dictFullName='" + dictFullName + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", flag=" + flag +
				", checkBy='" + checkBy + '\'' +
				", checkAt=" + checkAt +
				", isUsed=" + isUsed +
				", memo='" + memo + '\'' +
				", pycode='" + pycode + '\'' +
				", dataVersion=" + dataVersion +
				'}';
	}
}
