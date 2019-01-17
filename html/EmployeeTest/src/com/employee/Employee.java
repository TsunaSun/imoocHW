package com.employee;

public class Employee {
	private int empno;
	private String ename;
	private String department;
	private String job;
	private int salary;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int empno, String ename, String department, String job, int salary) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.department = department;
		this.job = job;
		this.salary = salary;
	}
	public Employee() {
		
	}
}
