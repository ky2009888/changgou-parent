package org.changgou.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:ky2009888
 * @Description:OauthCode构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OauthCode",value = "OauthCode")
@Table(name="oauth_code")
public class OauthCode implements Serializable{

	@ApiModelProperty(value = "",required = false)
    @Column(name = "code")
	private String code;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "authentication")
	private String authentication;//



	//get方法
	public String getCode() {
		return code;
	}

	//set方法
	public void setCode(String code) {
		this.code = code;
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
