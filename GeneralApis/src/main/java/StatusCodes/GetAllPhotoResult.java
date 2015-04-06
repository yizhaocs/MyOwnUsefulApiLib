package main.java.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class GetAllPhotoResult extends PagingResult<GetAllPhotosDataCell>
{

    public GetAllPhotoResult()
    {
        super();
    }

    public GetAllPhotoResult(String status)
    {
        super(status);

    }

}
