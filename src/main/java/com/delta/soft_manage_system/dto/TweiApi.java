package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_API
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_api")
public class TweiApi implements Serializable {
	/***/
	@TableId(type = IdType.NONE)
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
