package main.java.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class ToUserDeletedByResult extends ToUserResult{
    private String toStatus;
    private Long deletedById;
    private String deletedByUserName;

    public ToUserDeletedByResult()
    {
    }

    public ToUserDeletedByResult(Long id, String name)
    {
        super(id, name);
    }

    public ToUserDeletedByResult(Long id, String name, String toStatus, Long deletedById, String deletedByUserName) {
        super(id, name);
        this.toStatus = toStatus;
        this.deletedById = deletedById;
        this.deletedByUserName = deletedByUserName;
    }

    public String getToStatus() {
        return toStatus;
    }

    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    public Long getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(Long deletedById) {
        this.deletedById = deletedById;
    }

    public String getDeletedByUserName() {
        return deletedByUserName;
    }

    public void setDeletedByUserName(String deletedByUserName) {
        this.deletedByUserName = deletedByUserName;
    }
}
