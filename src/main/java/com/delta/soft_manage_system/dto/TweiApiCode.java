package com.delta.soft_manage_system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TWEI_API_CODE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
public class TweiApiCode {
	/***/
	private String codeId; 
	/***/
	private String codeName; 
	/***/
	private String definition;
	/***/
	private Integer apiId; 
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
