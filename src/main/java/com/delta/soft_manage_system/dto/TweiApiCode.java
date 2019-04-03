package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_API_CODE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_api_code")
public class TweiApiCode implements Serializable {
	/***/
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	private String codeId; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="代碼名稱")
	private String codeName; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="代碼定義")
	private String definition;
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="APIID")
	private String apiId;
	/***/
	private String codeType; 
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
		return "TweiApiCode{" +
				"codeId='" + codeId + '\'' +
				", codeName='" + codeName + '\'' +
				", dEFINITION='" + definition + '\'' +
				", apiId=" + apiId +
				", codeType='" + codeType + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
