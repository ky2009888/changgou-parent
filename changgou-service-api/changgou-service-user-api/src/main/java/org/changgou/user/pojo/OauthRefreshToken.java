package org.changgou.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:ky2009888
 * @Description:OauthRefreshToken构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OauthRefreshToken",value = "OauthRefreshToken")
@Table(name="oauth_refresh_token")
public class OauthRefreshToken implements Serializable{

	@ApiModelProperty(value = "",required = false)
    @Column(name = "token_id")
	private String tokenId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "token")
	private String token;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "authentication")
	private String authentication;//



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
	public String getAuthentication() {
		return authentication;
	}

	//set方法
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}


}
