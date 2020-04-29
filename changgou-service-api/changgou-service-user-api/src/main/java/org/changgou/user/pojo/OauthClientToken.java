package org.changgou.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:ky2009888
 * @Description:OauthClientToken构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OauthClientToken",value = "OauthClientToken")
@Table(name="oauth_client_token")
public class OauthClientToken implements Serializable{

	@ApiModelProperty(value = "",required = false)
    @Column(name = "token_id")
	private String tokenId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "token")
	private String token;//

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "authentication_id")
	private String authenticationId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_name")
	private String userName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "client_id")
	private String clientId;//



	//get方法
	public String getTokenId() {
		return tokenId;
	}

	//set方法
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	//get方法
	public String getToken() {
		return token;
	}

	//set方法
	public void setToken(String token) {
		this.token = token;
	}
	//get方法
	public String getAuthenticationId() {
		return authenticationId;
	}

	//set方法
	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}
	//get方法
	public String getUserName() {
		return userName;
	}

	//set方法
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


}
