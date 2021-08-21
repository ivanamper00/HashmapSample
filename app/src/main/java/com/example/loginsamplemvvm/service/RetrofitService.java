package com.example.loginsamplemvvm.service;

import com.example.loginsamplemvvm.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static <S> S retrofitService(Class<S> serviceClass){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.APP_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    public interface ResultHandler<T> {
        public void onSuccess(T data);
        public void onError(String Error);
    }

}



//Service {
//    companion object{
//        fun <S> retrofitService(serviceClass: Class<S>?): S {
//            val retrofit = Retrofit.Builder()
//                    .baseUrl(Constants.APP_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            return retrofit.create(serviceClass!!)
//        }
//
//        fun <S> retrofitService(serviceClass: Class<S>?, token: String): S {
//            val retrofit = Retrofit.Builder()
//                    .baseUrl(Constants.APP_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(headers(token)!!)
//                .build()
//            return retrofit.create(serviceClass!!)
//        }
//
//        private fun headers(userToken: String): OkHttpClient? {
//                val httpClient = OkHttpClient.Builder()
//                httpClient.addInterceptor { chain ->
//                val original: Request = chain.request()
//        val request: Request = original.newBuilder()
//                .header("Accept", "application/json")
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer $userToken")
//                .method(original.method(), original.body())
//                .build()
//        chain.proceed(request)
//            }
//        return httpClient.build()
//        }
//    }
//
//}