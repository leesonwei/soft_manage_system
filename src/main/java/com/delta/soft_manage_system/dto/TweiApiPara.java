package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_API_PARA
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_api_para")
public class TweiApiPara implements Serializable {
	/***/
	@NullRule(name = "所屬API", action={ActionType.INSERT,ActionType.UPDATE})
	private String apiId;
	/***/
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	private String paraId;
	/***/
	@NullRule(name = "參數名稱", action={ActionType.INSERT,ActionType.UPDATE})
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
	@DataVersion
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
