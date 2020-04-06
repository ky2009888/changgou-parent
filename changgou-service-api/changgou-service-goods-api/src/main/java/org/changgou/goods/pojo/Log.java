package org.changgou.goods.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * log实体类
 * @author Lenovo
 *
 */
@Table(name="undo_log")
@Data
public class Log implements Serializable {
	/**
	 *id
	 */
	@Id
	private Long id;
	/**
	 *branch_id
	 */
	private Long branchId;
	/**
	 *xid
	 */
	private String xid;
	/**
	 *rollback_info
	 */
	private byte[] rollbackInfo;
	/**
	 *log_status
	 */
	private Integer logStatus;
	/**
	 *log_created
	 */
	private java.util.Date logCreated;
	/**
	 *log_modified
	 */
	private java.util.Date logModified;
	/**
	 *ext
	 */
	private String ext;
}
