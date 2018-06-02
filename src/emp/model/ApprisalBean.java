package emp.model;

public class ApprisalBean {

	private int userId;
	private int appraisalId;
	private String objective;
	private String empComment;
	private String hrComment;
	private int rating;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getEmpComment() {
		return empComment;
	}
	public void setEmpComment(String empComment) {
		this.empComment = empComment;
	}
	public String getHrComment() {
		return hrComment;
	}
	public void setHrComment(String hrComment) {
		this.hrComment = hrComment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public int getAppraisalId() {
		return appraisalId;
	}
	public void setAppraisalId(int appraisalId) {
		this.appraisalId = appraisalId;
	}
	public ApprisalBean(int userId, String objective, String empComment) {
		super();
		this.userId = userId;
		this.objective = objective;
		this.empComment = empComment;
	}
	
	public ApprisalBean(int userId, int appraisalId, String objective,
			String empComment, String hrComment, int rating) {
		super();
		this.userId = userId;
		this.appraisalId = appraisalId;
		this.objective = objective;
		this.empComment = empComment;
		this.hrComment = hrComment;
		this.rating = rating;
	}
	public ApprisalBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApprisalBean [userId=" + userId + ", objective=" + objective
				+ ", empComment=" + empComment + ", hrComment=" + hrComment
				+ ", rating=" + rating + "]";
	}
	
}
