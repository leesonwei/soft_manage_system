package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.AutoField.FieldInfo;
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
	@TableId
	@Check(id=true,type= CheckId.INPUT,action = {ActionType.UPDATE,ActionType.DELETE})
	@FieldInfo("ID")
	private String dictId;

	/***/
	@NullRule(name="數據字典類型",action=ActionType.INSERT)
	@FieldInfo("類型")
	private String typeId; 

	/***/
	@NullRule(name="數據字典名稱")
	@FieldInfo("名稱")
	private String dictName; 
	/***/
	@FieldInfo("簡稱")
	private String dictShortName; 
	/***/
	@FieldInfo("全稱")
	private String dictFullName; 
	/***/
	@FieldInfo("創建人")
	private String createBy; 
	/***/
	@FieldInfo("創建時間")
	private Date createAt;
	/***/
	@FieldInfo("更新人")
	private String updateBy; 
	/***/
	@FieldInfo("更新時間")
	private Date updateAt;
	/***/
	@FieldInfo("審核狀態")
	private Integer flag;
	/***/
	@FieldInfo("審核人")
	private String checkBy; 
	/***/
	@FieldInfo("審核時間")
	private Date checkAt;
	/***/
	@FieldInfo("啟用過")
	private Integer isUsed; 
	/***/
	@FieldInfo("備註")
	private String memo;
	/***/
	@FieldInfo("拼音碼")
	private String pycode;
	/***/
	@DataVersion
	@FieldInfo("數據版本")
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
