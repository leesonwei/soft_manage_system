package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_api_para实体类
 * 
 * @author 
 *
 */
public class TweiApiPara {
	/***/
	private Integer apiId; 
	/***/
	private Integer paraId; 
	/***/
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
	public TweiApiPara() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiApiPara(JSONObject obj) {
		this();
		if (obj.get("apiId") instanceof Number) {
			this.setApiId(((Number) obj.get("apiId")).intValue());
		}
		if (obj.get("paraId") instanceof Number) {
			this.setParaId(((Number) obj.get("paraId")).intValue());
		}
		if (obj.get("paraName") instanceof String) {
			this.setParaName((String) obj.get("paraName"));
		}
		if (obj.get("paraType") instanceof String) {
			this.setParaType((String) obj.get("paraType"));
		}
		if (obj.get("paraDataType") instanceof String) {
			this.setParaDataType((String) obj.get("paraDataType"));
		}
		if (obj.get("isNullable") instanceof Number) {
			this.setIsNullable(((Number) obj.get("isNullable")).intValue());
		}
		if (obj.get("paraMemo") instanceof String) {
			this.setParaMemo((String) obj.get("paraMemo"));
		}
		if (obj.get("parentParaId") instanceof Number) {
			this.setParentParaId(((Number) obj.get("parentParaId")).intValue());
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
		if (this.getApiId() != null) {
			result.put("apiId",this.getApiId());
		}
		if (this.getParaId() != null) {
			result.put("paraId",this.getParaId());
		}
		if (this.getParaName() != null) {
			result.put("paraName",this.getParaName());
		}
		if (this.getParaType() != null) {
			result.put("paraType",this.getParaType());
		}
		if (this.getParaDataType() != null) {
			result.put("paraDataType",this.getParaDataType());
		}
		if (this.getIsNullable() != null) {
			result.put("isNullable",this.getIsNullable());
		}
		if (this.getParaMemo() != null) {
			result.put("paraMemo",this.getParaMemo());
		}
		if (this.getParentParaId() != null) {
			result.put("parentParaId",this.getParentParaId());
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
	 * 获取paraId
	 * 
	 * @return
	 */
	public Integer getParaId() {
		return paraId;
	}

	/**
	 * 设置paraId
	 * 
	 * @param paraId
	 */
	public void setParaId(Integer paraId) {
		this.paraId = paraId;
	}
	
	/**
	 * 获取paraName
	 * 
	 * @return
	 */
	public String getParaName() {
		return paraName;
	}

	/**
	 * 设置paraName
	 * 
	 * @param paraName
	 */
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	
	/**
	 * 获取paraType
	 * 
	 * @return
	 */
	public String getParaType() {
		return paraType;
	}

	/**
	 * 设置paraType
	 * 
	 * @param paraType
	 */
	public void setParaType(String paraType) {
		this.paraType = paraType;
	}
	
	/**
	 * 获取paraDataType
	 * 
	 * @return
	 */
	public String getParaDataType() {
		return paraDataType;
	}

	/**
	 * 设置paraDataType
	 * 
	 * @param paraDataType
	 */
	public void setParaDataType(String paraDataType) {
		this.paraDataType = paraDataType;
	}
	
	/**
	 * 获取isNullable
	 * 
	 * @return
	 */
	public Integer getIsNullable() {
		return isNullable;
	}

	/**
	 * 设置isNullable
	 * 
	 * @param isNullable
	 */
	public void setIsNullable(Integer isNullable) {
		this.isNullable = isNullable;
	}
	
	/**
	 * 获取paraMemo
	 * 
	 * @return
	 */
	public String getParaMemo() {
		return paraMemo;
	}

	/**
	 * 设置paraMemo
	 * 
	 * @param paraMemo
	 */
	public void setParaMemo(String paraMemo) {
		this.paraMemo = paraMemo;
	}
	
	/**
	 * 获取parentParaId
	 * 
	 * @return
	 */
	public Integer getParentParaId() {
		return parentParaId;
	}

	/**
	 * 设置parentParaId
	 * 
	 * @param parentParaId
	 */
	public void setParentParaId(Integer parentParaId) {
		this.parentParaId = parentParaId;
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
		return "TweiApiPara [apiId=" + apiId + " , paraId=" + paraId + " , paraName=" + paraName + " , paraType=" + paraType + " , paraDataType=" + paraDataType + " , isNullable=" + isNullable + " , paraMemo=" + paraMemo + " , parentParaId=" + parentParaId + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
