package com.delta.soft_manage_system.dto;

import lombok.Data;

/**
 * @Classname TWEI_DICT_TYPE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
public class TweiDictType {
	/***/
	private String typeId; 
	/***/
	private String typeName; 
	/***/
	private String mEMO; 
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
		return "TweiDictType{" +
				"typeId='" + typeId + '\'' +
				", typeName='" + typeName + '\'' +
				", mEMO='" + mEMO + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
