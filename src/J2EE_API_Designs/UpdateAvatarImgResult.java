package J2EE_API_Designs;

/**
 * Created by yizhao on 1/21/15.
 */
public class UpdateAvatarImgResult extends StatusResult {
    private String avatarUrl;

    public UpdateAvatarImgResult() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UpdateAvatarImgResult(int status) {
        super(status);
        // TODO Auto-generated constructor stub
    }

    public UpdateAvatarImgResult(String status) {
        super(status);
        // TODO Auto-generated constructor stub
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}

