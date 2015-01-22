package J2EE_API_Designs;

/**
 * Created by yizhao on 1/21/15.
 */
public class SharePhotoResult extends StatusResult {
    private Long id;

    private Long createTime;

    private String url;

    public SharePhotoResult() {
        super();

    }

    public SharePhotoResult(Long id, Long createTime, String url) {
        super();
        this.id = id;
        this.createTime = createTime;
        this.url = url;
    }

    public SharePhotoResult(String status) {
        super(status);
    }

    public SharePhotoResult(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
