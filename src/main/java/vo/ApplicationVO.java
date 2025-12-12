package vo;

import java.util.Date;

public class ApplicationVO {
    private int id;
    private int recruitId;
    private int applicantUserId;
    private String applicantName;
    private String message;
    private Date createdAt;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRecruitId() { return recruitId; }
    public void setRecruitId(int recruitId) { this.recruitId = recruitId; }

    public int getApplicantUserId() { return applicantUserId; }
    public void setApplicantUserId(int applicantUserId) { this.applicantUserId = applicantUserId; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
