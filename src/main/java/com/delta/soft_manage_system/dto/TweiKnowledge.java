package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname TWEI_KNOWLEDGE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */

@Data
@TableName("twei_hnowledge")
public class TweiKnowledge implements Serializable {
	/***/
	@TableId
	private String codeId; 
	/***/
	private String knowId; 
	/***/
	private String knowDetail; 
	/***/
	private String knowType; 
	/***/
	private Integer isHelp; 
	/***/
	private Integer isUnhelp; 
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
		return "TweiKnowledge{" +
				"codeId='" + codeId + '\'' +
				", knowId='" + knowId + '\'' +
				", knowDetail='" + knowDetail + '\'' +
				", knowType='" + knowType + '\'' +
				", isHelp=" + isHelp +
				", isUnhelp=" + isUnhelp +
				", createBy='" + createBy + '\'' +
				", createAt=" + createAt +
				", updateBy='" + updateBy + '\'' +
				", updateAt=" + updateAt +
				", dataVersion=" + dataVersion +
				'}';
	}
}
