package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_API API實體類
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_api")
public class TweiApi implements Serializable {
	/**
	 * API類型
	 */
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API外鍵ID")
	private String apiTypeId;
	/**
	 * API ID
	 */
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API主鍵ID")
	private String apiId;
	/**
	 * API名稱
	 */
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API名稱")
	private String apiName; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API描述")
	private String apiDesc;
	/**
	 * API調用地址
	 */
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API地址")
	@UrlRule(value = "API地址",action = ActionType.INSERT)
	private String apiUrl;
	/**
	 * API方法名
	 */
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="API方法")
	private String apiMethod;
	/**
	 * API請求示例
	 */
	private String requestExample;
	/**
	 * API響應示例
	 */
	private String responseExample;
	/**
	 * API異常示例
	 */
	private String faultExample;
	/**
	 * 創建人
	 */
	private String createBy;
	/**
	 * 創建時間
	 */
	private Date createAt;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新時間
	 */
	private Date updateAt;
	/**
	 * 數據版本
	 */
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
