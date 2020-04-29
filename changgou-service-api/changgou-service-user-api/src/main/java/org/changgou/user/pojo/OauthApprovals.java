package org.changgou.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:ky2009888
 * @Description:OauthApprovals构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OauthApprovals",value = "OauthApprovals")
@Table(name="oauth_approvals")
public class OauthApprovals implements Serializable{

	@ApiModelProperty(value = "",required = false)
    @Column(name = "userId")
	private String userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "clientId")
	private String clientId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "scope")
	private String scope;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "status")
	private String status;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "expiresAt")
	private Date expiresAt;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "lastModifiedAt")
	private Date lastModifiedAt;//



	//get方法
	public String getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	//get方法
	public String getScope() {
		return scope;
	}

	//set方法
	public void setScope(String scope) {
		this.scope = scope;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public Date getExpiresAt() {
		return expiresAt;
	}

	//set方法
	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}
	//get方法
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	//set方法
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}


}
