package sn.esmt.projetrechercheemploi;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.google.android.material.button.MaterialButton;
        import com.google.android.material.textfield.TextInputEditText;

        import java.util.List;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import sn.esmt.projetrechercheemploi.model.CvEntities;
        import sn.esmt.projetrechercheemploi.retrofit.CvApi;
        import sn.esmt.projetrechercheemploi.retrofit.RetrofitService;

public class MainActivity extends AppCompatActivity {

    private Button afficher_les_cv;
    private Button inserer_un_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        afficher_les_cv = (Button) findViewById(R.id.button);
        inserer_un_cv = (Button) findViewById(R.id.button2);

        afficher_les_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListCvActivity.class);
                startActivity(intent);

            }

        });
        inserer_un_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AfficheCvActivity.class);
                startActivity(intent);

            }
        });
    }
}



