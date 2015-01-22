package J2EE_API_Designs.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class StatusResult {
    private String status;

    public StatusResult() {
        this.status = Constants.STATUS_CODE_SUCCESS;
    }

    public StatusResult(String status) {
        this.status = status;
    }

    public StatusResult(int status) {
        this.status = Integer.toString(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}