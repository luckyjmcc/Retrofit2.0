package xb.com.retrofit.service;


import org.json.JSONObject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import rx.Observable;
import xb.com.retrofit.entity.LoginEntity;

public interface APIService {
    //https://futurestud.io/blog/retrofit-add-custom-request-header
    @Headers("Cache-Control: max-age=640000")
    @GET(RetrofitUtils.LOGIN)
    Call<String> loginString(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);

    @GET(RetrofitUtils.LOGIN)
    Call<LoginEntity> loginFastJson(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);

    @GET(RetrofitUtils.LOGIN)
    Call<JSONObject> loginJson(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);


    @GET(RetrofitUtils.LOGIN)
    Observable<String> loginObservableString(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);

    @GET(RetrofitUtils.LOGIN)
    Observable<LoginEntity> loginObservableFastJson(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);

    @GET(RetrofitUtils.LOGIN)
    Observable<JSONObject> loginObservableJson(
            @Query("yongHuMing") String yongHuMing,
            @Query("miMa") String password,
            @Query("leiXing") int leiXing,
            @Query("jingDu") double jingDu,
            @Query("weiDu") double weiDu);


}
