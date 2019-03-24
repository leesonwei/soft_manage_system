package com.delta.soft_manage_system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TWEI_API_PARA
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
public class TweiApiPara {
	/***/
	private Integer apiId; 
	/***/
	private Integer paraId; 
	/***/
	private String paraName; 
	/***/
	private String paraType; 
	/***/
	private String paraDataType; 
	/***/
	private Integer isNullable; 
	/***/
	private String paraMemo; 
	/***/
	private Integer parentParaId; 
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
		return "TweiApiPara{" +
				"apiId=" + apiId +
				", paraId=" + paraId +
				", paraName='" + paraName + '\'' +
				", paraType='" + paraType + '\'' +
				", paraDataType='" + paraDataType + '\'' +
				", isNullable=" + isNullable +
				", paraMemo='" + paraMemo + '\'' +
				", parentParaId=" + parentParaId +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
