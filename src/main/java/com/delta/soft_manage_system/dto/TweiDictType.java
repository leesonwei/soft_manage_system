package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_DICT_TYPE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */
@Data
@TableName("twei_dict_type")
public class TweiDictType implements Serializable {
	/***/
	@TableId(type = IdType.AUTO)
	private Long typeId;
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
