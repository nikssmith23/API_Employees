package com.marcos.pojo;

public class EmployeeVo {

	private String name;
	private String phoneno;
	private String department;
	private String status;
	private String createddtm;
	private String createdby;
	private String updateddtm;
	private String updatedby;
	private int cid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(String createddtm) {
		this.createddtm = createddtm;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(String updateddtm) {
		this.updateddtm = updateddtm;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "EmployeeVo [name=" + name + ", phoneno=" + phoneno + ", department=" + department + ", status=" + status
				+ ", createddtm=" + createddtm + ", createdby=" + createdby + ", updateddtm=" + updateddtm
				+ ", updatedby=" + updatedby + ", cid=" + cid + "]";
	}

	public EmployeeVo(String name, String phoneno, String department, String status, String createddtm,
			String createdby, String updateddtm, String updatedby, int cid) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.department = department;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.cid = cid;
	}

	public EmployeeVo() {
		super();
	}

}
