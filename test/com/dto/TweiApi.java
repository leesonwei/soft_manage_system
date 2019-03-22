package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_api实体类
 * 
 * @author 
 *
 */
public class TweiApi {
	/***/
	private Integer apiTypeId; 
	/***/
	private Integer apiId; 
	/***/
	private String apiName; 
	/***/
	private String apiDesc; 
	/***/
	private String apiUrl; 
	/***/
	private String apiMethod; 
	/***/
	private String requestExample; 
	/***/
	private String responseExample; 
	/***/
	private String faultExample; 
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
	public TweiApi() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiApi(JSONObject obj) {
		this();
		if (obj.get("apiTypeId") instanceof Number) {
			this.setApiTypeId(((Number) obj.get("apiTypeId")).intValue());
		}
		if (obj.get("apiId") instanceof Number) {
			this.setApiId(((Number) obj.get("apiId")).intValue());
		}
		if (obj.get("apiName") instanceof String) {
			this.setApiName((String) obj.get("apiName"));
		}
		if (obj.get("apiDesc") instanceof String) {
			this.setApiDesc((String) obj.get("apiDesc"));
		}
		if (obj.get("apiUrl") instanceof String) {
			this.setApiUrl((String) obj.get("apiUrl"));
		}
		if (obj.get("apiMethod") instanceof String) {
			this.setApiMethod((String) obj.get("apiMethod"));
		}
		if (obj.get("requestExample") instanceof String) {
			this.setRequestExample((String) obj.get("requestExample"));
		}
		if (obj.get("responseExample") instanceof String) {
			this.setResponseExample((String) obj.get("responseExample"));
		}
		if (obj.get("faultExample") instanceof String) {
			this.setFaultExample((String) obj.get("faultExample"));
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
		if (this.getApiId() != null) {
			result.put("apiId",this.getApiId());
		}
		if (this.getApiName() != null) {
			result.put("apiName",this.getApiName());
		}
		if (this.getApiDesc() != null) {
			result.put("apiDesc",this.getApiDesc());
		}
		if (this.getApiUrl() != null) {
			result.put("apiUrl",this.getApiUrl());
		}
		if (this.getApiMethod() != null) {
			result.put("apiMethod",this.getApiMethod());
		}
		if (this.getRequestExample() != null) {
			result.put("requestExample",this.getRequestExample());
		}
		if (this.getResponseExample() != null) {
			result.put("responseExample",this.getResponseExample());
		}
		if (this.getFaultExample() != null) {
			result.put("faultExample",this.getFaultExample());
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
	 * 获取apiName
	 * 
	 * @return
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * 设置apiName
	 * 
	 * @param apiName
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
	/**
	 * 获取apiDesc
	 * 
	 * @return
	 */
	public String getApiDesc() {
		return apiDesc;
	}

	/**
	 * 设置apiDesc
	 * 
	 * @param apiDesc
	 */
	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}
	
	/**
	 * 获取apiUrl
	 * 
	 * @return
	 */
	public String getApiUrl() {
		return apiUrl;
	}

	/**
	 * 设置apiUrl
	 * 
	 * @param apiUrl
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	/**
	 * 获取apiMethod
	 * 
	 * @return
	 */
	public String getApiMethod() {
		return apiMethod;
	}

	/**
	 * 设置apiMethod
	 * 
	 * @param apiMethod
	 */
	public void setApiMethod(String apiMethod) {
		this.apiMethod = apiMethod;
	}
	
	/**
	 * 获取requestExample
	 * 
	 * @return
	 */
	public String getRequestExample() {
		return requestExample;
	}

	/**
	 * 设置requestExample
	 * 
	 * @param requestExample
	 */
	public void setRequestExample(String requestExample) {
		this.requestExample = requestExample;
	}
	
	/**
	 * 获取responseExample
	 * 
	 * @return
	 */
	public String getResponseExample() {
		return responseExample;
	}

	/**
	 * 设置responseExample
	 * 
	 * @param responseExample
	 */
	public void setResponseExample(String responseExample) {
		this.responseExample = responseExample;
	}
	
	/**
	 * 获取faultExample
	 * 
	 * @return
	 */
	public String getFaultExample() {
		return faultExample;
	}

	/**
	 * 设置faultExample
	 * 
	 * @param faultExample
	 */
	public void setFaultExample(String faultExample) {
		this.faultExample = faultExample;
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
		return "TweiApi [apiTypeId=" + apiTypeId + " , apiId=" + apiId + " , apiName=" + apiName + " , apiDesc=" + apiDesc + " , apiUrl=" + apiUrl + " , apiMethod=" + apiMethod + " , requestExample=" + requestExample + " , responseExample=" + responseExample + " , faultExample=" + faultExample + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
