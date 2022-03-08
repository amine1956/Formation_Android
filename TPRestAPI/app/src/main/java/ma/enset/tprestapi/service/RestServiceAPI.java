package ma.enset.tprestapi.service;

import java.sql.Date;
import java.util.List;

import ma.enset.tprestapi.model.ListArticleResonse;
import ma.enset.tprestapi.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestServiceAPI {

    @GET("v2/everything")
    Call<ListArticleResonse> listUsersByKey(@Query("q") String key, @Query("date") Date dta , @Query("apiKey") String s);
    @GET("users")
    Call<List<Article>> listUsers();

}
