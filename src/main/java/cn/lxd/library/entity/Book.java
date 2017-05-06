package cn.lxd.library.entity;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
		private Integer id;
	    private String bno;
	    private String bname;
	    private Integer tid;
	    private String author;//作者
	    private Double price;//单价
	    private String brief;//简介
	    private Integer total;//有多少书
	    private Integer remain;//剩下多少书
	    private Date cdate;//创建时间
	    private Date udate;//归换时间
	    private Integer yn;//类型
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getBno() {
			return bno;
		}
		public void setBno(String bno) {
			this.bno = bno;
		}
		public String getBname() {
			return bname;
		}
		public void setBname(String bname) {
			this.bname = bname;
		}
		public Integer getTid() {
			return tid;
		}
		public void setTid(Integer tid) {
			this.tid = tid;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getBrief() {
			return brief;
		}
		public void setBrief(String brief) {
			this.brief = brief;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public Integer getRemain() {
			return remain;
		}
		public void setRemain(Integer remain) {
			this.remain = remain;
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Book [id=" + id + ", bno=" + bno + ", bname=" + bname + ", tid=" + tid + ", author=" + author
					+ ", price=" + price + ", brief=" + brief + ", total=" + total + ", remain=" + remain + ", cdate="
					+ cdate + ", udate=" + udate + ", yn=" + yn + "]";
		}
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Book(Integer id, String bno, String bname, Integer tid, String author, Double price, String brief,
				Integer total, Integer remain, Date cdate, Date udate, Integer yn) {
			super();
			this.id = id;
			this.bno = bno;
			this.bname = bname;
			this.tid = tid;
			this.author = author;
			this.price = price;
			this.brief = brief;
			this.total = total;
			this.remain = remain;
			this.cdate = cdate;
			this.udate = udate;
			this.yn = yn;
		}

	    
	    
}