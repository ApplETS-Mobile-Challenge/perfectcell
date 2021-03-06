package com.amc.applets.perfectcell.ApiClient;

import com.amc.applets.perfectcell.model.AbstractUser;
import com.amc.applets.perfectcell.model.Donation;
import com.amc.applets.perfectcell.model.Giver;
import com.amc.applets.perfectcell.model.Receiver;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Yves on 2/13/2016.
 * Interface class defining endpoints and methods for data access.
 */
public interface ApiInterface {

    @Headers("User-Agent: PerfectCell-AMC2016")


    @GET("/givers/")
    Call<List<Giver>> getGivers();

    /*
    @GET("/givers/(id}")
    Call<Giver> getGiversById(@Query("q") String id);
    */

    @GET("/perfectcell-api/users/list")
    Call<List<Giver>> listUsers();

    @GET("/perfectcell-api/donations/list")
    Call<List<Donation>> listDonations();

    @GET("/getuser/{id}")
    Call<AbstractUser> getUser(@Query("q") String id);
    @POST("/adduser")
    Call<AbstractUser> createTask(@Body AbstractUser user);

}
