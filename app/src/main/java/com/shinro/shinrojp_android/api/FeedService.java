package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.models.NHKProgramList;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FeedService {

    /**
     * Get data from services
    */
    @GET("/list/130/g1/{current_date}.json?key={api_key}")
    Observable<ArrayList<NHKProgramList>> fetchProgramList(@Path("current_date") String current_date, @Path("api_key") String api_key);

    @GET("/info/130/g1/{id}.json?key={api_key}")
    Observable<ArrayList<NHKProgramList>> fetchProgramDetail(@Path("id") int id, @Path("api_key") String api_key);

}
