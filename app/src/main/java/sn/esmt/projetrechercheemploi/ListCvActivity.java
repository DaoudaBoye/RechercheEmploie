package sn.esmt.projetrechercheemploi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import sn.esmt.projetrechercheemploi.adapter.CvAdapter;
import sn.esmt.projetrechercheemploi.model.CvEntities;
import sn.esmt.projetrechercheemploi.retrofit.CvApi;
import sn.esmt.projetrechercheemploi.retrofit.RetrofitService;

public class ListCvActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcv);

        recyclerView = findViewById(R.id.cvList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadcvuser();

    }

    private void loadcvuser() {
        RetrofitService retrofitService = new RetrofitService();
        CvApi cvApi = retrofitService.getRetrofit().create(CvApi.class);
        cvApi.all()
                .enqueue(new Callback<List<CvEntities>>() {
                    @Override
                    public void onResponse(Call<List<CvEntities>> call, Response<List<CvEntities>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CvEntities>> call, Throwable t) {
                        Toast.makeText(ListCvActivity.this, "Failed to load CV", Toast.LENGTH_SHORT).show();
                    }

                });
    };

    private void populateListView(List<CvEntities> cvList) {
        CvAdapter cvAdapter = new CvAdapter(cvList);
        recyclerView.setAdapter(cvAdapter);
    }

}



