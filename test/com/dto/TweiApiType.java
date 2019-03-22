package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_api_type实体类
 * 
 * @author 
 *
 */
public class TweiApiType {
	/***/
	private Integer apiTypeId; 
	/***/
	private String apiTypeName; 
	/***/
	private String apiTypeMemo; 
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
	public TweiApiType() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiApiType(JSONObject obj) {
		this();
		if (obj.get("apiTypeId") instanceof Number) {
			this.setApiTypeId(((Number) obj.get("apiTypeId")).intValue());
		}
		if (obj.get("apiTypeName") instanceof String) {
			this.setApiTypeName((String) obj.get("apiTypeName"));
		}
		if (obj.get("apiTypeMemo") instanceof String) {
			this.setApiTypeMemo((String) obj.get("apiTypeMemo"));
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
		if (this.getApiTypeId() != null) {
			result.put("apiTypeId",this.getApiTypeId());
		}
		if (this.getApiTypeName() != null) {
			result.put("apiTypeName",this.getApiTypeName());
		}
		if (this.getApiTypeMemo() != null) {
			result.put("apiTypeMemo",this.getApiTypeMemo());
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
	 * 获取apiTypeId
	 * 
	 * @return
	 */
	public Integer getApiTypeId() {
		return apiTypeId;
	}

	/**
	 * 设置apiTypeId
	 * 
	 * @param apiTypeId
	 */
	public void setApiTypeId(Integer apiTypeId) {
		this.apiTypeId = apiTypeId;
	}
	
	/**
	 * 获取apiTypeName
	 * 
	 * @return
	 */
	public String getApiTypeName() {
		return apiTypeName;
	}

	/**
	 * 设置apiTypeName
	 * 
	 * @param apiTypeName
	 */
	public void setApiTypeName(String apiTypeName) {
		this.apiTypeName = apiTypeName;
	}
	
	/**
	 * 获取apiTypeMemo
	 * 
	 * @return
	 */
	public String getApiTypeMemo() {
		return apiTypeMemo;
	}

	/**
	 * 设置apiTypeMemo
	 * 
	 * @param apiTypeMemo
	 */
	public void setApiTypeMemo(String apiTypeMemo) {
		this.apiTypeMemo = apiTypeMemo;
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
		return "TweiApiType [apiTypeId=" + apiTypeId + " , apiTypeName=" + apiTypeName + " , apiTypeMemo=" + apiTypeMemo + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
