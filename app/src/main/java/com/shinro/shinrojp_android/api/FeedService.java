package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.models.NHK.NHKProgramList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FeedService {

    /**
     * Get data from services
    */
    @GET("list/130/g1/{current_date}.json")
    Observable<NHKProgramList> fetchProgramList(@Path("current_date") String current_date, @Query("key") String api_key);

    @GET("info/130/g1/{id}.json")
    Observable<NHKProgramList> fetchProgramDetail(@Path("id") String id, @Query("key") String api_key);

}
