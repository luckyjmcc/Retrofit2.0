# Retrofit2.0使用

####三种convert
 **1、convert **

1. [fastjson](https://github.com/iloveaman/Retrofit2.0/tree/master/app/src/main/java/xb/com/retrofit/convert/fastjson)

		将服务器返回结果转换成实体类
2. [json](https://github.com/iloveaman/Retrofit2.0/tree/master/app/src/main/java/xb/com/retrofit/convert/json) 

		将服务器返回结果转换成json对象
3. [string](https://github.com/iloveaman/Retrofit2.0/tree/master/app/src/main/java/xb/com/retrofit/convert/string) 
			
		将服务器返回结果转换成字符串

**2、使用方法 **

```
 Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
						.addConverterFactory(StringConverterFactory.create())
						.addConverterFactory(JsonConverterFactory.create())
						.addConverterFactory(FastJsonConvertFactory.create());
```
	  三者可共同使用,根据传入的类型返回相应的类型。
