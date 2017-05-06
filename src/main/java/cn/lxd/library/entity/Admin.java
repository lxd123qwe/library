package cn.lxd.library.entity;

import java.io.Serializable;
import java.sql.Date;

public class Admin implements Serializable{

	private static final long serialVersionUID = -7313871073154660850L;
	
		private Integer id;
	    private String ano;
	    private String aname;
	    private String password;
	    private Date cdate;
	    private Date udate;
	    private Integer yn;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getAno() {
			return ano;
		}
		public void setAno(String ano) {
			this.ano = ano;
		}
		public String getAname() {
			return aname;
		}
		public void setAname(String aname) {
			this.aname = aname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getCdate() {
			return cdate;
		}
		public void setCdate(Date cdate) {
			this.cdate = cdate;
		}
		public Date getUdate() {
			return udate;
		}
		public void setUdate(Date udate) {
			this.udate = udate;
		}
		public Integer getYn() {
			return yn;
		}
		public void setYn(Integer yn) {
			this.yn = yn;
		}
		public Admin(Integer id, String ano, String aname, String password, Date cdate, Date udate, Integer yn) {
			super();
			this.id = id;
			this.ano = ano;
			this.aname = aname;
			this.password = password;
			this.cdate = cdate;
			this.udate = udate;
			this.yn = yn;
		}
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", ano=" + ano + ", aname=" + aname + ", password=" + password + ", cdate="
					+ cdate + ", udate=" + udate + ", yn=" + yn + "]";
		}
	    
	    
}
