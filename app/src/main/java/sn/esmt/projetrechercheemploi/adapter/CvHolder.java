package sn.esmt.projetrechercheemploi.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sn.esmt.projetrechercheemploi.R;

public class CvHolder extends RecyclerView.ViewHolder {

    TextView prenom, nom, age, adresse, email, telephone, specialite, niveauEtude, experienceProfessionnelle;

    public CvHolder(@NonNull View itemView) {
        super(itemView);
        prenom = itemView.findViewById(R.id.cventitesListItem_prenom);
        nom = itemView.findViewById(R.id.cventitesListItem_nom);
        age = itemView.findViewById(R.id.cventitesListItem_age);
        adresse = itemView.findViewById(R.id.cventitesListItem_adresse);
        email = itemView.findViewById(R.id.cventitesListItem_email);
        telephone = itemView.findViewById(R.id.cventitesListItem_telephone);
        specialite = itemView.findViewById(R.id.cventitesListItem_specialite);
        niveauEtude = itemView.findViewById(R.id.cventitesListItem_niveauEtude);
        experienceProfessionnelle = itemView.findViewById(R.id.cventitesListItem_experienceProfessionnelle);



    }
}