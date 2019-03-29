package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.delta.soft_manage_system.AutoField.FieldInfo;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_DICT_TYPE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_dict_type")
public class TweiDictType implements Serializable {
	/***/
	@TableId(type = IdType.INPUT)
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	@FieldInfo("ID")
	private String typeId;
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="類型名稱")
	@FieldInfo("類型名稱")
	private String typeName; 
	/***/
	@FieldInfo("備註")
	private String memo;
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
	@DataVersion
	@FieldInfo("數據版本")
	private Integer dataVersion;


	@Override
	public String toString() {
		return "TweiDictType{" +
				"typeId='" + typeId + '\'' +
				", typeName='" + typeName + '\'' +
				", mEMO='" + memo + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
