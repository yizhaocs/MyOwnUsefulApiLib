package J2EE_API_Designs;

import org.apache.log4j.Logger;

/**
 * Created by yizhao on 1/21/15.
 */
public class Constants {
    private static final Logger log = Logger.getLogger(Constants.class);

    // generic error code
    public static final String STATUS_CODE_SUCCESS = "0";

    public static final String STATUS_CODE_INTERNAL_SERVER_ERROR = "103";

    public static final String STATUS_CODE_APIKEY_INVALID = "104";

    public static final String STATUS_CODE_APIKEY_NULL = "108";

    public static final String INVALID_SESSION_OR_BAD_SESSION_AUTH_PAIR = "120";
}
