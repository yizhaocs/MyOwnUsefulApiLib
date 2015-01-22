package J2EE_API_Designs.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class ToUserResult {
    private Long id;
    private String name;

    public ToUserResult()
    {

    }

    public ToUserResult(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId ()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
