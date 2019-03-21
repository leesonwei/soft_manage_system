package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_knowledge实体类
 * 
 * @author 
 *
 */
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
	/**
	 * 实例化
	 */
	public TweiKnowledge() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiKnowledge(JSONObject obj) {
		this();
		if (obj.get("codeId") instanceof String) {
			this.setCodeId((String) obj.get("codeId"));
		}
		if (obj.get("knowId") instanceof String) {
			this.setKnowId((String) obj.get("knowId"));
		}
		if (obj.get("knowDetail") instanceof String) {
			this.setKnowDetail((String) obj.get("knowDetail"));
		}
		if (obj.get("knowType") instanceof String) {
			this.setKnowType((String) obj.get("knowType"));
		}
		if (obj.get("isHelp") instanceof Number) {
			this.setIsHelp(((Number) obj.get("isHelp")).intValue());
		}
		if (obj.get("isUnhelp") instanceof Number) {
			this.setIsUnhelp(((Number) obj.get("isUnhelp")).intValue());
		}
		if (obj.get("createBy") instanceof String) {
			this.setCreateBy((String) obj.get("createBy"));
		}
		this.setCreateAt(obj.get("createAt"));
		if (obj.get("updateBy") instanceof String) {
			this.setUpdateBy((String) obj.get("updateBy"));
		}
		this.setUpdateAt(obj.get("updateAt"));
		if (obj.get("dataVersion") instanceof Number) {
			this.setDataVersion(((Number) obj.get("dataVersion")).intValue());
		}
	}
	
	/**
	 * 将当前对象转换为JsonObject
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		JSONObject result = new JSONObject();
		if (this.getCodeId() != null) {
			result.put("codeId",this.getCodeId());
		}
		if (this.getKnowId() != null) {
			result.put("knowId",this.getKnowId());
		}
		if (this.getKnowDetail() != null) {
			result.put("knowDetail",this.getKnowDetail());
		}
		if (this.getKnowType() != null) {
			result.put("knowType",this.getKnowType());
		}
		if (this.getIsHelp() != null) {
			result.put("isHelp",this.getIsHelp());
		}
		if (this.getIsUnhelp() != null) {
			result.put("isUnhelp",this.getIsUnhelp());
		}
		if (this.getCreateBy() != null) {
			result.put("createBy",this.getCreateBy());
		}
		if (this.getCreateAt() != null) {
			result.put("createAt",this.getCreateAt());
		}
		if (this.getUpdateBy() != null) {
			result.put("updateBy",this.getUpdateBy());
		}
		if (this.getUpdateAt() != null) {
			result.put("updateAt",this.getUpdateAt());
		}
		if (this.getDataVersion() != null) {
			result.put("dataVersion",this.getDataVersion());
		}
		return result;
	}
	
	
	/**
	 * 获取codeId
	 * 
	 * @return
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * 设置codeId
	 * 
	 * @param codeId
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	
	/**
	 * 获取knowId
	 * 
	 * @return
	 */
	public String getKnowId() {
		return knowId;
	}

	/**
	 * 设置knowId
	 * 
	 * @param knowId
	 */
	public void setKnowId(String knowId) {
		this.knowId = knowId;
	}
	
	/**
	 * 获取knowDetail
	 * 
	 * @return
	 */
	public String getKnowDetail() {
		return knowDetail;
	}

	/**
	 * 设置knowDetail
	 * 
	 * @param knowDetail
	 */
	public void setKnowDetail(String knowDetail) {
		this.knowDetail = knowDetail;
	}
	
	/**
	 * 获取knowType
	 * 
	 * @return
	 */
	public String getKnowType() {
		return knowType;
	}

	/**
	 * 设置knowType
	 * 
	 * @param knowType
	 */
	public void setKnowType(String knowType) {
		this.knowType = knowType;
	}
	
	/**
	 * 获取isHelp
	 * 
	 * @return
	 */
	public Integer getIsHelp() {
		return isHelp;
	}

	/**
	 * 设置isHelp
	 * 
	 * @param isHelp
	 */
	public void setIsHelp(Integer isHelp) {
		this.isHelp = isHelp;
	}
	
	/**
	 * 获取isUnhelp
	 * 
	 * @return
	 */
	public Integer getIsUnhelp() {
		return isUnhelp;
	}

	/**
	 * 设置isUnhelp
	 * 
	 * @param isUnhelp
	 */
	public void setIsUnhelp(Integer isUnhelp) {
		this.isUnhelp = isUnhelp;
	}
	
	/**
	 * 获取createBy
	 * 
	 * @return
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置createBy
	 * 
	 * @param createBy
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	/**
	 * 获取createAt
	 * 
	 * @return
	 */
	public java.time.Instant getCreateAt() {
		return createAt;
	}

	/**
	 * 设置createAt
	 * 
	 * @param createAt
	 */
	public void setCreateAt(java.time.Instant createAt) {
		this.createAt = createAt;
	}
	
	/**
	 * 获取updateBy
	 * 
	 * @return
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置updateBy
	 * 
	 * @param updateBy
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	/**
	 * 获取updateAt
	 * 
	 * @return
	 */
	public java.time.Instant getUpdateAt() {
		return updateAt;
	}

	/**
	 * 设置updateAt
	 * 
	 * @param updateAt
	 */
	public void setUpdateAt(java.time.Instant updateAt) {
		this.updateAt = updateAt;
	}
	
	/**
	 * 获取dataVersion
	 * 
	 * @return
	 */
	public Integer getDataVersion() {
		return dataVersion;
	}

	/**
	 * 设置dataVersion
	 * 
	 * @param dataVersion
	 */
	public void setDataVersion(Integer dataVersion) {
		this.dataVersion = dataVersion;
	}

	@Override
	public String toString() {
		return "TweiKnowledge [codeId=" + codeId + " , knowId=" + knowId + " , knowDetail=" + knowDetail + " , knowType=" + knowType + " , isHelp=" + isHelp + " , isUnhelp=" + isUnhelp + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
