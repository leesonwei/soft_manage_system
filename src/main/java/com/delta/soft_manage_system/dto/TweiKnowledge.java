package com.delta.soft_manage_system.dto;

import lombok.Data;

/**
 * @Classname TWEI_KNOWLEDGE
 * @Date 2019.3.22
 * @author lizong.wei
 * @Since 1.8
 */

@Data
public class TweiKnowledge {
	/***/
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
	private java.time.Instant createAt; 
	/***/
	private String updateBy; 
	/***/
	private java.time.Instant updateAt; 
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
