package com.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * twei_dict实体类
 * 
 * @author 
 *
 */
public class TweiDict {
	/***/
	private String typeId; 
	/***/
	private String dictId; 
	/***/
	private String dictName; 
	/***/
	private String dictShortName; 
	/***/
	private String dictFullName; 
	/***/
	private String createBy; 
	/***/
	private java.time.Instant createAt; 
	/***/
	private String updateBy; 
	/***/
	private java.time.Instant updateAt; 
	/***/
	private Integer flag; 
	/***/
	private String checkBy; 
	/***/
	private java.time.Instant checkAt; 
	/***/
	private Integer isUsed; 
	/***/
	private String memo; 
	/***/
	private String pycode; 
	/***/
	private Integer dataVersion; 
	/**
	 * 实例化
	 */
	public TweiDict() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public TweiDict(JSONObject obj) {
		this();
		if (obj.get("typeId") instanceof String) {
			this.setTypeId((String) obj.get("typeId"));
		}
		if (obj.get("dictId") instanceof String) {
			this.setDictId((String) obj.get("dictId"));
		}
		if (obj.get("dictName") instanceof String) {
			this.setDictName((String) obj.get("dictName"));
		}
		if (obj.get("dictShortName") instanceof String) {
			this.setDictShortName((String) obj.get("dictShortName"));
		}
		if (obj.get("dictFullName") instanceof String) {
			this.setDictFullName((String) obj.get("dictFullName"));
		}
		if (obj.get("createBy") instanceof String) {
			this.setCreateBy((String) obj.get("createBy"));
		}
		this.setCreateAt(obj.get("createAt"));
		if (obj.get("updateBy") instanceof String) {
			this.setUpdateBy((String) obj.get("updateBy"));
		}
		this.setUpdateAt(obj.get("updateAt"));
		if (obj.get("flag") instanceof Number) {
			this.setFlag(((Number) obj.get("flag")).intValue());
		}
		if (obj.get("checkBy") instanceof String) {
			this.setCheckBy((String) obj.get("checkBy"));
		}
		this.setCheckAt(obj.get("checkAt"));
		if (obj.get("isUsed") instanceof Number) {
			this.setIsUsed(((Number) obj.get("isUsed")).intValue());
		}
		if (obj.get("memo") instanceof String) {
			this.setMemo((String) obj.get("memo"));
		}
		if (obj.get("pycode") instanceof String) {
			this.setPycode((String) obj.get("pycode"));
		}
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
		if (this.getTypeId() != null) {
			result.put("typeId",this.getTypeId());
		}
		if (this.getDictId() != null) {
			result.put("dictId",this.getDictId());
		}
		if (this.getDictName() != null) {
			result.put("dictName",this.getDictName());
		}
		if (this.getDictShortName() != null) {
			result.put("dictShortName",this.getDictShortName());
		}
		if (this.getDictFullName() != null) {
			result.put("dictFullName",this.getDictFullName());
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
		if (this.getFlag() != null) {
			result.put("flag",this.getFlag());
		}
		if (this.getCheckBy() != null) {
			result.put("checkBy",this.getCheckBy());
		}
		if (this.getCheckAt() != null) {
			result.put("checkAt",this.getCheckAt());
		}
		if (this.getIsUsed() != null) {
			result.put("isUsed",this.getIsUsed());
		}
		if (this.getMemo() != null) {
			result.put("memo",this.getMemo());
		}
		if (this.getPycode() != null) {
			result.put("pycode",this.getPycode());
		}
		if (this.getDataVersion() != null) {
			result.put("dataVersion",this.getDataVersion());
		}
		return result;
	}
	
	
	/**
	 * 获取typeId
	 * 
	 * @return
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * 设置typeId
	 * 
	 * @param typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	/**
	 * 获取dictId
	 * 
	 * @return
	 */
	public String getDictId() {
		return dictId;
	}

	/**
	 * 设置dictId
	 * 
	 * @param dictId
	 */
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	
	/**
	 * 获取dictName
	 * 
	 * @return
	 */
	public String getDictName() {
		return dictName;
	}

	/**
	 * 设置dictName
	 * 
	 * @param dictName
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	
	/**
	 * 获取dictShortName
	 * 
	 * @return
	 */
	public String getDictShortName() {
		return dictShortName;
	}

	/**
	 * 设置dictShortName
	 * 
	 * @param dictShortName
	 */
	public void setDictShortName(String dictShortName) {
		this.dictShortName = dictShortName;
	}
	
	/**
	 * 获取dictFullName
	 * 
	 * @return
	 */
	public String getDictFullName() {
		return dictFullName;
	}

	/**
	 * 设置dictFullName
	 * 
	 * @param dictFullName
	 */
	public void setDictFullName(String dictFullName) {
		this.dictFullName = dictFullName;
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
	 * 获取flag
	 * 
	 * @return
	 */
	public Integer getFlag() {
		return flag;
	}

	/**
	 * 设置flag
	 * 
	 * @param flag
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	/**
	 * 获取checkBy
	 * 
	 * @return
	 */
	public String getCheckBy() {
		return checkBy;
	}

	/**
	 * 设置checkBy
	 * 
	 * @param checkBy
	 */
	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}
	
	/**
	 * 获取checkAt
	 * 
	 * @return
	 */
	public java.time.Instant getCheckAt() {
		return checkAt;
	}

	/**
	 * 设置checkAt
	 * 
	 * @param checkAt
	 */
	public void setCheckAt(java.time.Instant checkAt) {
		this.checkAt = checkAt;
	}
	
	/**
	 * 获取isUsed
	 * 
	 * @return
	 */
	public Integer getIsUsed() {
		return isUsed;
	}

	/**
	 * 设置isUsed
	 * 
	 * @param isUsed
	 */
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	
	/**
	 * 获取memo
	 * 
	 * @return
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 设置memo
	 * 
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	/**
	 * 获取pycode
	 * 
	 * @return
	 */
	public String getPycode() {
		return pycode;
	}

	/**
	 * 设置pycode
	 * 
	 * @param pycode
	 */
	public void setPycode(String pycode) {
		this.pycode = pycode;
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
		return "TweiDict [typeId=" + typeId + " , dictId=" + dictId + " , dictName=" + dictName + " , dictShortName=" + dictShortName + " , dictFullName=" + dictFullName + " , createBy=" + createBy + " , createAt=" + createAt + " , updateBy=" + updateBy + " , updateAt=" + updateAt + " , flag=" + flag + " , checkBy=" + checkBy + " , checkAt=" + checkAt + " , isUsed=" + isUsed + " , memo=" + memo + " , pycode=" + pycode + " , dataVersion=" + dataVersion + "  ]";
	
	}
	
	
}
