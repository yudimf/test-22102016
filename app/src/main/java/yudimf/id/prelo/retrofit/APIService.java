package yudimf.id.prelo.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import yudimf.id.prelo.models.SuccessResponse;
import yudimf.id.prelo.models.User;

/**
 * Created by yudimf on 21/10/17.
 */

public interface APIService {
    @POST("auth/login")
    Call<SuccessResponse> login(@Body User user);
}
