package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
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
	private String apiTypeId;
	/***/
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API主鍵ID")
	private String apiId;
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API名稱")
	private String apiName; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API描述")
	private String apiDesc; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API地址")
	@UrlRule("API地址")
	private String apiUrl; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API方法")
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
	@DataVersion
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
