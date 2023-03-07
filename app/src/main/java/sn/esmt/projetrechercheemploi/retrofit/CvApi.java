package sn.esmt.projetrechercheemploi.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sn.esmt.projetrechercheemploi.model.CvEntities;

public interface CvApi {

    @GET("/cvuser/all")
    Call<List<CvEntities>> all();

    @POST("/cvuser/save")
    Call<CvEntities> save(@Body CvEntities cvEntities);
}
