package sn.esmt.projetrechercheemploi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sn.esmt.projetrechercheemploi.R;
import sn.esmt.projetrechercheemploi.model.CvEntities;

public class CvAdapter extends RecyclerView.Adapter<CvHolder> {
    private List<CvEntities> cvList;

    public CvAdapter(List<CvEntities> cvList){
        this.cvList = cvList;

    }



    @NonNull
    @Override
    public CvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_cv_item, parent, false);
        return new CvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CvHolder holder, int position) {

        CvEntities cvEntities = cvList.get(position);
        holder.prenom.setText(cvEntities.getPrenom());
        holder.nom.setText(cvEntities.getNom());
        holder.age.setText(cvEntities.getAge());
        holder.adresse.setText(cvEntities.getAdresse());
        holder.email.setText(cvEntities.getEmail());
        holder.telephone.setText(cvEntities.getTelephone());
        holder.niveauEtude.setText(cvEntities.getNiveauEtude());
        holder.specialite.setText(cvEntities.getSpecialite());
        holder.experienceProfessionnelle.setText(cvEntities.getExperienceProfessionnelle());





    }

    @Override
    public int getItemCount() {

        return cvList.size();
    }
}
