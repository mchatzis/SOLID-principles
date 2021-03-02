import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IRetrofit {

    @Headers({
            "Content-type: application/json",
            "charset: UTF-8"
    })
    @POST("posts")
    Call<Product> postProduct(@Body String jsonProduct);
}
