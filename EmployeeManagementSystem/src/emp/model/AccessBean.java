package emp.model;

public class AccessBean {
	private int accessId;
	private String accessVal;

	public int getAccessId() {
		return accessId;
	}

	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}

	public String getAccessVal() {
		return accessVal;
	}

	public void setAccessVal(String accessVal) {
		this.accessVal = accessVal;
	}

	@Override
	public String toString() {
		return "AccessBean [accessId=" + accessId + ", accessVal=" + accessVal
				+ "]";
	}

	public AccessBean(int accessId, String accessVal) {
		super();
		this.accessId = accessId;
		this.accessVal = accessVal;
	}

	public AccessBean() {
		super();
	}

}
