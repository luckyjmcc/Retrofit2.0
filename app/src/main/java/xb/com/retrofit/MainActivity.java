package xb.com.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alexvasilkov.android.commons.utils.Views;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func3;
import rx.schedulers.Schedulers;
import xb.com.retrofit.base.BaseActivity;
import xb.com.retrofit.entity.LoginEntity;
import xb.com.retrofit.service.APIService;
import xb.com.retrofit.service.ActivityCallback;
import xb.com.retrofit.service.RetrofitUtils;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    ViewHolder mViews;
    APIService mAPIService;
    String mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViews = new ViewHolder(this);
        mUsername = mViews.edit_username.getText().toString();
        mPassword = mViews.edit_password.getText().toString();
        mViews.btn_login.setOnClickListener(this);
        mAPIService = RetrofitUtils.createApi(RxJavaCallAdapterFactory.create());

        Logger.init("Retrofit2.0");
        //Logger.d("Hello , this is a test project !");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mViews.tv_result.setText("");
                login();
                break;
        }
    }

    //--------------------------------------------------------------------------------------
    private void login() {
        //--------------(1)
        //1.StringConverterFactory
        Call<String> call1 = mAPIService.loginString(mUsername, mPassword, 1, 0.0d, 0.0d);
        call1.enqueue(new LoginCallbackString(this));
        //2.FastJsonConvertFactory
        Call<LoginEntity> call2 = mAPIService.loginFastJson(mUsername, mPassword, 1, 0.0d, 0.0d);
        call2.enqueue(new LoginCallbackFastJson(this));
        //2.JsonConverterFactory
        Call<JSONObject> call3 = mAPIService.loginJson(mUsername, mPassword, 1, 0.0d, 0.0d);
        call3.enqueue(new LoginCallbackJson(this));

        //--------------(2)
        //Observable<String> observableString = mAPIService.loginObservableString(mUsername, mPassword, 1, 0.0d, 0.0d);
        //Observable<LoginEntity> observableFastJson = mAPIService.loginObservableFastJson(mUsername, mPassword, 1, 0.0d, 0.0d);
        //Observable<JSONObject> observableJson = mAPIService.loginObservableJson(mUsername, mPassword, 1, 0.0d, 0.0d);
        mAPIService.loginObservableString(mUsername, mPassword, 1, 0.0d, 0.0d)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(getApplicationContext(),
                                "Completed",
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(),
                                e.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onNext(String response) {
                        Toast.makeText(getApplicationContext(),
                                response,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        //--------------(3)
//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber observer) {
//                try {
//                    if (!observer.isUnsubscribed()) {
//                        for (int i = 1; i < 5; i++) {
//                            observer.onNext(i);
//                        }
//                        observer.onCompleted();
//                    }
//                } catch (Exception e) {
//                    observer.onError(e);
//                }
//            }
//        }).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onNext(Integer item) {
//                Logger.d("Next: " + item);
//            }
//
//            @Override
//            public void onError(Throwable error) {
//                Logger.d("Error: " + error.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                Logger.d("Sequence complete.");
//            }
//        });
        //--------------(4)
        //retrofit对Observable的支持使得它可以很简单的将多个REST请求结合起来。
        // 比如我们有一个请求是获取照片的，还有 ,一个请求是获取元数据的，我们就可以将这两个请求并发的发出，并且等待两个结果都返回之后再做处理：
        Observable.zip(
                mAPIService.loginObservableString(mUsername, mPassword, 1, 0.0d, 0.0d),
                mAPIService.loginObservableFastJson(mUsername, mPassword, 1, 0.0d, 0.0d),
                mAPIService.loginObservableJson(mUsername, mPassword, 1, 0.0d, 0.0d),
                new Func3<String, LoginEntity, JSONObject, Object>() {
                    @Override
                    public Object call(String s, LoginEntity loginEntity, JSONObject jsonObject) {
                        Logger.d("-----" + s);
                        return null;
                    }
                }
                /*(loginObservableString, loginObservableFastJson, loginObservableJson) -> mulRestRequest(loginObservableString, loginObservableFastJson, loginObservableJson))
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onNext(Boolean item) {
                        Logger.d("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Logger.d("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        Logger.d("Sequence complete.");
                    }
                }*/);
    }

    private Boolean mulRestRequest(String loginObservableString, LoginEntity loginObservableFastJson, JSONObject loginObservableJson) {
        Logger.i(loginObservableString + "\n" +
                loginObservableFastJson.toString() + "\n"
                + loginObservableJson.toString());
        return false;
    }

    //--------------------------------------------------------------------------------------
    private static final class LoginCallbackString extends ActivityCallback<String> {
        public LoginCallbackString(BaseActivity activity) {
            super(activity);
        }

        @Override
        public void onResponse(Response<String> response, Retrofit retrofit) {
            MainActivity activity = (MainActivity) getActivity();
            if (activity != null) {
                String result = activity.mViews.tv_result.getText().toString() + "\n(1) LoginCallbackString：\n" + response.body() + "\n";
                activity.mViews.tv_result.setText(result);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Logger.d(t.toString());
        }
    }

    private static final class LoginCallbackFastJson extends ActivityCallback<LoginEntity> {
        public LoginCallbackFastJson(BaseActivity activity) {
            super(activity);
        }

        @Override
        public void onResponse(Response<LoginEntity> response, Retrofit retrofit) {
            MainActivity activity = (MainActivity) getActivity();
            if (activity != null) {
                String result = activity.mViews.tv_result.getText().toString() + "\n(2) LoginCallbackFastJson：\n" + response.body().toString() + "\n";
                activity.mViews.tv_result.setText(result);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Logger.d(t.toString());
        }
    }


    private static final class LoginCallbackJson extends ActivityCallback<JSONObject> {
        public LoginCallbackJson(BaseActivity activity) {
            super(activity);
        }

        @Override
        public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
            MainActivity activity = (MainActivity) getActivity();
            if (activity != null) {
                String result = activity.mViews.tv_result.getText().toString() + "\n(3) LoginCallbackJson：\n" + response.body().toString() + "\n";
                activity.mViews.tv_result.setText(result);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Logger.d(t.toString());
        }
    }

    //--------------------------------------------------------------------------------------
    private class ViewHolder {
        public TextView tv_result;
        public EditText edit_username, edit_password;
        public Button btn_login;
        public Toolbar toolbar;

        public ViewHolder(Activity activity) {
            tv_result = Views.find(activity, R.id.tv_result);
            edit_username = Views.find(activity, R.id.edit_username);
            edit_password = Views.find(activity, R.id.edit_password);
            btn_login = Views.find(activity, R.id.btn_login);
            toolbar = Views.find(activity, R.id.toolbar);
            setSupportActionBar(toolbar);
        }
    }

}
