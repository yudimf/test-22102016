package yudimf.id.prelo.retrofit;

/**
 * Created by yudimf on 21/10/17.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://dev.prelo.id/api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
