package com.muthukumarasamy.rolehierarchy.dto;

public class Data {

	private String role;
	private String reportingto;
	private String name;

	public Data(String role, String reportingto, String name) {
		setName(name);
		setRole(role);
		setReportingto(reportingto);
	}

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReportingto() {
		return reportingto;
	}

	public void setReportingto(String reportingto) {
		this.reportingto = reportingto;
	}

	@Override
	public String toString() {
		return "D{" + "name='" + name + '\'' + ", role='" + role + '\'' + ", reportingto='" + reportingto + '\'' + '}';
	}

}
