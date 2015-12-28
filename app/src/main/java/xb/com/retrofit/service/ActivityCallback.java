package xb.com.retrofit.service;

import android.app.Activity;

import java.lang.ref.WeakReference;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xb.com.retrofit.base.BaseActivity;

/**
 * Created by Administrator on 2015/12/16.
 */
public class ActivityCallback<T> implements Callback<T> {
    //软引用，缓存引用对象
    private final WeakReference<BaseActivity> mRef;

    public ActivityCallback(BaseActivity activity) {
        mRef = new WeakReference<BaseActivity>(activity);
    }


    public Activity getActivity() {
        return mRef.get();
    }

    /**
     * 在Retrofit 1.9中，如果获取的 response 不能背解析成定义好的对象，则会调用failure。但是在Retrofit 2.0中，不管 response 是否能被解析。onResponse总是会被调用。但是在结果不能背解析的情况下，response.body()会返回null
     *
     * @param response
     * @param retrofit
     */
    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
