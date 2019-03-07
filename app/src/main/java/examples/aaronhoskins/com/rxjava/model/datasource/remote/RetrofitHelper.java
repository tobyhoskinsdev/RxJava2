package examples.aaronhoskins.com.rxjava.model.datasource.remote;

import examples.aaronhoskins.com.rxjava.model.user.UserResponse;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class RetrofitHelper {

    private static OkHttpClient  getOkHttpClientWithIntercepter() {
        //Declare Interceptor for http logging
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //Set http logging level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //return new OkHttp Client with interceptor attached
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static Retrofit getRetrofit() {
        //Build retrofit instance
        return new Retrofit
                .Builder()
                .baseUrl(ApiConstants.BASE_URL) //Base URL of the api source
                .client(getOkHttpClientWithIntercepter()) //add new okhttp client with interceptor
                .addConverterFactory(GsonConverterFactory.create())// add object converter factory
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build(); //build the instance
    }

    //create the interface instance in retrofit
    private ObservableInterface createUserResponceInterface() {
        return getRetrofit().create(ObservableInterface.class);
    }

    //Execute rest call
    public Observable<UserResponse> getUserResponseObservable(String numResults, String gender) {
        return createUserResponceInterface().getUserResponseObservable(numResults, gender);
    }


    //Interface for the observable
    public interface ObservableInterface {
        @GET(ApiConstants.PATH_API)
        Observable<UserResponse> getUserResponseObservable(
                @Query(ApiConstants.QUERY_RESULTS) String numOfResultsDesired,
                @Query(ApiConstants.QUERY_GENDER) String requestedGender);
    }

}
