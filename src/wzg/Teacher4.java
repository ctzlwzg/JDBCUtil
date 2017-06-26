package wzg;
/*
* @author  作者: ctzl
* @date 创建时间：2017年6月26日 上午9:07:59 
* @version 1.0 
* 表结构和类对应
*/public class Teacher4 {
	private Integer teacher_id;
	private String teaacher_name;
	private String  teacher_gender;
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeaacher_name() {
		return teaacher_name;
	}
	public void setTeaacher_name(String teaacher_name) {
		this.teaacher_name = teaacher_name;
	}
	public String getTeacher_gender() {
		return teacher_gender;
	}
	public void setTeacher_gender(String teacher_gender) {
		this.teacher_gender = teacher_gender;
	}
	public Teacher4(Integer teacher_id, String teaacher_name, String teacher_gender) {
		super();
		this.teacher_id = teacher_id;
		this.teaacher_name = teaacher_name;
		this.teacher_gender = teacher_gender;
	}
	
	public Teacher4(){}

}
