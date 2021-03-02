import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerWriter implements IWriter{

    @Override
    public void write(String jsonProduct) throws Exception {
        Call<Product> serverCall = RetroService.postProduct(jsonProduct);
        Response<Product> response = serverCall.execute();
        System.out.println(response.body());
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            // .addConverterFactory(GsonConverterFactory.create())
            .build();

    IRetrofit RetroService = retrofit.create(IRetrofit.class);
}
