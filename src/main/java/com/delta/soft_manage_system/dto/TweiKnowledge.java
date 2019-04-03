package com.delta.soft_manage_system.dto;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.delta.soft_manage_system.entitycheck.*;
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
@TableName("twei_knowledge")
public class TweiKnowledge implements Serializable {
	/***/
	private String codeId; 
	/***/
	@TableId
	@Check(id = true, type = CheckId.INPUT, action = { ActionType.DELETE, ActionType.UPDATE})
	private String knowId;
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="知識庫標題")
	private String knowTitle;
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="知識庫詳情")
	private String knowDetail; 
	/***/
	@NullRule(action={ActionType.INSERT, ActionType.UPDATE}, name="知識庫類型")
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
	@DataVersion
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
