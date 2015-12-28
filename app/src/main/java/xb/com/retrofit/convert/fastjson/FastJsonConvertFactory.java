package xb.com.retrofit.convert.fastjson;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by Administrator on 2015/12/16.
 */
public final class FastJsonConvertFactory extends Converter.Factory {

    public static FastJsonConvertFactory create() {
        return new FastJsonConvertFactory();
    }

    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        if (!JSONObject.class.equals(type)) {
            return new FastJsonResponseBodyConverter<>(type);
        }
        return null;
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        if (!JSONObject.class.equals(type)) {
            return new FastJsonRequestBodyConvert<>();
        }
        return null;
    }
}
