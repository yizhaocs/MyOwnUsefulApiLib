package J2EE_API_Designs.StatusCodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 1/21/15.
 */
public class PagingResult<C extends DataCell> extends StatusResult
{
    private List<C> data = new ArrayList<C>();

    private DataPaging paging; // = new DataPaging();

    public PagingResult()
    {
        super();
    }

    public PagingResult(String status)
    {
        super(status);
        if (getStatus() != Constants.STATUS_CODE_SUCCESS) {
            data = null;
        }
    }

    public void addData(C c)
    {
        if (data == null) {
            data = new ArrayList<C>();
        }
        this.data.add(c);
    }

    public void setNext(String nextUrl)
    {
        if (paging == null) {
            paging = new DataPaging();
        }
        paging.setNext(nextUrl);
    }

    public void setPrevious(String previousUrl)
    {
        if (paging == null) {
            paging = new DataPaging();
        }
        paging.setPrevious(previousUrl);
    }

    public List<C> getData()
    {
        return data;
    }

    public DataPaging getPaging()
    {
        return paging;
    }

}
