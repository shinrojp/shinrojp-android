package com.shinro.shinrojp_android.api;

import com.shinro.shinrojp_android.models.ItemGrammar;
import java.util.ArrayList;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GrammarService {

    /**
     * Get data from services
     */
    @GET("api")
    Observable<ArrayList<ItemGrammar>> getGrammarData();
}
