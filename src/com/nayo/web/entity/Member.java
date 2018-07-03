package com.nayo.web.entity;

public class Member {
	
	private String email;
	private String pwd;
	private String nickname;
	private String birth;
	private String gender;
	private String profilepic;
	private String intro;
	
	public Member(String email, String pwd, String nickname, String birth, String gender, String profilepic,
			String intro) {
		
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
		this.birth = birth;
		this.gender = gender;
		this.profilepic = profilepic;
		this.intro = intro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
	
	
}