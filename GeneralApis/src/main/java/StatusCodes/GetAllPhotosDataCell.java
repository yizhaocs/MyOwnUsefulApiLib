package main.java.StatusCodes;

import java.util.List;

/**
 * Created by yizhao on 1/21/15.
 */
public class GetAllPhotosDataCell implements DataCell
{
    private Long id;

    private String title;

    private String url;

    private String fromName;

    private Long fromId;

    private Long createTime;

    private String fromAvatarUrl;

    private String size;

    private String url_tn;

    private String size_tn;

    private List<ToUserDeletedByResult> to;

    private String status;

    public GetAllPhotosDataCell()
    {

    }

    public GetAllPhotosDataCell(Long id, String title, String url, String fromName, Long fromId, Long createTime,
                                String fromAvatarUrl)
    {
        super();
        this.id = id;
        this.title = title;
        this.url = url;
        this.fromName = fromName;
        this.fromId = fromId;
        this.createTime = createTime;
        this.fromAvatarUrl = fromAvatarUrl;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getFromName()
    {
        return fromName;
    }

    public void setFromName(String fromName)
    {
        this.fromName = fromName;
    }

    public Long getFromId()
    {
        return fromId;
    }

    public void setFromId(Long fromId)
    {
        this.fromId = fromId;
    }

    public Long getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Long createTime)
    {
        this.createTime = createTime;
    }

    public String getFromAvatarUrl()
    {
        return fromAvatarUrl;
    }

    public void setFromAvatarUrl(String fromAvatarUrl)
    {
        this.fromAvatarUrl = fromAvatarUrl;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getUrl_tn()
    {
        return url_tn;
    }

    public void setUrl_tn(String url_tn)
    {
        this.url_tn = url_tn;
    }

    public String getSize_tn()
    {
        return size_tn;
    }

    public void setSize_tn(String size_tn)
    {
        this.size_tn = size_tn;
    }

    public List<ToUserDeletedByResult> getTo()
    {
        return to;
    }

    public void setTo(List<ToUserDeletedByResult> to)
    {
        this.to = to;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
