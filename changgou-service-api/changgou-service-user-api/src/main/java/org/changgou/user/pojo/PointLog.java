package org.changgou.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:ky2009888
 * @Description:PointLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "PointLog",value = "PointLog")
@Table(name="tb_point_log")
public class PointLog implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "order_id")
	private String orderId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private String userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "point")
	private Integer point;//



	//get方法
	public String getOrderId() {
		return orderId;
	}

	//set方法
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	//get方法
	public String getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//get方法
	public Integer getPoint() {
		return point;
	}

	//set方法
	public void setPoint(Integer point) {
		this.point = point;
	}


}
