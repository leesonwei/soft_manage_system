package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_api_code实体类
 * 
 * @author 
 *
 */
public class TweiApiCode {
	/***/
	private String codeId; 
	/***/
	private String codeName; 
	/***/
	private String definition; 
	/***/
	private Integer apiId; 
	/***/
	private String codeType; 
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
	public TweiApiCode() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiApiCode(JSONObject obj) {
		this();
		if (obj.get("codeId") instanceof String) {
			this.setCodeId((String) obj.get("codeId"));
		}
		if (obj.get("codeName") instanceof String) {
			this.setCodeName((String) obj.get("codeName"));
		}
		if (obj.get("definition") instanceof String) {
			this.setDefinition((String) obj.get("definition"));
		}
		if (obj.get("apiId") instanceof Number) {
			this.setApiId(((Number) obj.get("apiId")).intValue());
		}
		if (obj.get("codeType") instanceof String) {
			this.setCodeType((String) obj.get("codeType"));
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
		if (this.getCodeName() != null) {
			result.put("codeName",this.getCodeName());
		}
		if (this.getDefinition() != null) {
			result.put("definition",this.getDefinition());
		}
		if (this.getApiId() != null) {
			result.put("apiId",this.getApiId());
		}
		if (this.getCodeType() != null) {
			result.put("codeType",this.getCodeType());
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
	 * 获取codeName
	 * 
	 * @return
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * 设置codeName
	 * 
	 * @param codeName
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	/**
	 * 获取definition
	 * 
	 * @return
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * 设置definition
	 * 
	 * @param definition
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	/**
	 * 获取apiId
	 * 
	 * @return
	 */
	public Integer getApiId() {
		return apiId;
	}

	/**
	 * 设置apiId
	 * 
	 * @param apiId
	 */
	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}
	
	/**
	 * 获取codeType
	 * 
	 * @return
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * 设置codeType
	 * 
	 * @param codeType
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
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
		return "TweiApiCode [codeId=" + codeId + " , codeName=" + codeName + " , definition=" + definition + " , apiId=" + apiId + " , codeType=" + codeType + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
