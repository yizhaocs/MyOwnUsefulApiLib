package J2EE_API_Designs.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class GetReceivedPhotoResult extends PagingResult<GetReceivedPhotosDataCell>
{

    public GetReceivedPhotoResult()
    {
        super();
    }

    public GetReceivedPhotoResult(String status)
    {
        super(status);

    }

}
