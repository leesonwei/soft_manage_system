package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_API_TYPE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */

@Data
@TableName("twei_api_type")
public class TweiApiType implements Serializable {
	/***/
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	private String apiTypeId;
	/***/
	@NullRule(name="API菜單名稱",action={ActionType.INSERT,ActionType.UPDATE})
	private String apiTypeName; 
	/***/
	private String apiTypeMemo; 
	/***/
	private String createBy; 
	/***/
	private Date createAt;
	/***/
	private String updateBy; 
	/***/
	private Date updateAt;
	/***/
	@DataVersion
	private Integer dataVersion;

	@Override
	public String toString() {
		return "TweiApiType{" +
				"apiTypeId=" + apiTypeId +
				", apiTypeName='" + apiTypeName + '\'' +
				", apiTypeMemo='" + apiTypeMemo + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
