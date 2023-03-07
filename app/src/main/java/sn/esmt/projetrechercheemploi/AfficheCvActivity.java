package sn.esmt.projetrechercheemploi;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class AfficheCvActivity extends AppCompatActivity {

    private TextInputEditText prenom_p;
    private TextInputEditText nom_p;
    private TextInputEditText age_p;
    private TextInputEditText adresse_p;
    private TextInputEditText email_p;
    private TextInputEditText telephone_p;
    private TextInputEditText specialite_p;
    private TextInputEditText niveauEtude_p;
    private TextInputEditText experienceProfessionnelle_p;
    private MaterialButton buttonSave;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cv_item_layout);

        prenom_p = (TextInputEditText) findViewById(R.id.form_textFieldPrenom);
        nom_p = (TextInputEditText) findViewById(R.id.form_textFieldNom);
        age_p = (TextInputEditText) findViewById(R.id.form_textFieldAge);
        adresse_p = (TextInputEditText) findViewById(R.id.form_textFieldAdresse);
        email_p = (TextInputEditText) findViewById(R.id.form_textFieldEmail);
        telephone_p = (TextInputEditText) findViewById(R.id.form_textFieldTelephone);
        specialite_p = (TextInputEditText) findViewById(R.id.form_textFieldSpecialite);
        niveauEtude_p = (TextInputEditText) findViewById(R.id.form_textFieldNiveauEtude);
        experienceProfessionnelle_p = (TextInputEditText) findViewById(R.id.form_textFieldExperienceProfessionnelle);
        buttonSave = (MaterialButton) findViewById(R.id.form_buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            RetrofitService retrofitService = new RetrofitService();
            CvApi cvApi = retrofitService.getRetrofit().create(CvApi.class);

            @Override
            public void onClick(View view) {
                String nom = nom_p.getText().toString();
                String prenom = prenom_p.getText().toString();
                String age = age_p.getText().toString();
                String adresse = adresse_p.getText().toString();
                String email = email_p.getText().toString();
                String telephone = telephone_p.getText().toString();
                String specialite = specialite_p.getText().toString();
                String niveauEtude = niveauEtude_p.getText().toString();
                String experienceProfessionnelle = experienceProfessionnelle_p.getText().toString();


                CvEntities cvEntities = new CvEntities();
                cvEntities.setPrenom(prenom);
                cvEntities.setNom(nom);
                cvEntities.setAge(age);
                cvEntities.setAdresse(adresse);
                cvEntities.setEmail(email);
                cvEntities.setTelephone(telephone);
                cvEntities.setNiveauEtude(niveauEtude);
                cvEntities.setExperienceProfessionnelle(experienceProfessionnelle);


                cvApi.save(cvEntities)
                        .enqueue(new Callback<CvEntities>() {
                            @Override
                            public void onResponse(Call<CvEntities> call, Response<CvEntities> response) {
                                Toast.makeText(AfficheCvActivity.this, "Sauvegarde réussi!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<CvEntities> call, Throwable t) {
                                Toast.makeText(AfficheCvActivity.this, "Echec du sauvegarde", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(AfficheCvActivity.class.getName()).log(Level.SEVERE, "Erreur", t);
                            }

                        });
            }
        });

    }
}



