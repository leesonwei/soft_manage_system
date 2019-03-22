package com.delta.soft_manage_system.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Classname TWEI_API
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
public class TweiApi {
	/***/
	private Integer apiTypeId; 
	/***/
	private Integer apiId; 
	/***/
	private String apiName; 
	/***/
	private String apiDesc; 
	/***/
	private String apiUrl; 
	/***/
	private String apiMethod; 
	/***/
	private String requestExample; 
	/***/
	private String responseExample; 
	/***/
	private String faultExample; 
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
		return "TweiApi{" +
				"apiTypeId=" + apiTypeId +
				", apiId=" + apiId +
				", apiName='" + apiName + '\'' +
				", apiDesc='" + apiDesc + '\'' +
				", apiUrl='" + apiUrl + '\'' +
				", apiMethod='" + apiMethod + '\'' +
				", requestExample='" + requestExample + '\'' +
				", responseExample='" + responseExample + '\'' +
				", faultExample='" + faultExample + '\'' +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
