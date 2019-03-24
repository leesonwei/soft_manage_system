package com.delta.soft_manage_system.dto;

import lombok.Data;

import java.util.Date;

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
	private String memo;
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
