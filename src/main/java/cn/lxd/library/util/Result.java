package cn.lxd.library.util;
import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer status;//状态
	private String msg;//消息
	private Object data;//数据
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
