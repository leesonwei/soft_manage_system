package com.delta.soft_manage_system.dto;

import lombok.Data;

/**
 * @Classname TWEI_API_TYPE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */

@Data
public class TweiApiType {
	/***/
	private Integer apiTypeId; 
	/***/
	private String apiTypeName; 
	/***/
	private String apiTypeMemo; 
	/***/
	private String createBy; 
	/***/
	private java.time.Instant createAt; 
	/***/
	private String updateBy; 
	/***/
	private java.time.Instant updateAt; 
	/***/
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
