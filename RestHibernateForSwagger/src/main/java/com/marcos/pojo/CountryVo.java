package com.marcos.pojo;

public class CountryVo {
	String cname;

	@Override
	public String toString() {
		return "CountryVo [cname=" + cname + "]";
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public CountryVo() {
		super();
	}

	public CountryVo(String cname) {
		super();
		this.cname = cname;
	}
}
