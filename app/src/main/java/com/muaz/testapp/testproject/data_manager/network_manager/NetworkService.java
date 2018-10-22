package com.muaz.testapp.testproject.data_manager.network_manager;

import com.muaz.testapp.testproject.data_manager.network_manager.modals.CompanyExpenses;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Me;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Token;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by muazekici on 16.07.2018.
 */

public interface NetworkService {

   @POST("oauth/token?grant_type=password")
    Single<Token> loginUser(@Query("username") String userName, @Query("password") String password,
                            @Query("client_id") String client_id, @Query("client_secret") String client_secret);

   @GET("v2/me")
    Single<Me> getMyInfo();

   @GET("v2/{company_id}/expenses")
    Single<CompanyExpenses> getCompanyExpenses(@Path("company_id") int companyId);
}
