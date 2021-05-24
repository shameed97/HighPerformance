package sha.personal.highperformance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sha.personal.highperformance.databinding.PatientViewBinding;

public class ViewPatientAdapter extends RecyclerView.Adapter<ViewPatientAdapter.MyHolder> {

    private final Context context;
    private  ArrayList<Patient.UserDetail> ticketArrayList;

    public ViewPatientAdapter(Context context, ArrayList<Patient.UserDetail> orderedProdList) {
        this.context = context;
        this.ticketArrayList = orderedProdList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PatientViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.patient_view, parent, false);

        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.patientViewBinding.setPatient(ticketArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return ticketArrayList.size();
    }

    public void updateList(ArrayList<Patient.UserDetail> ticketArrayList) {
        this.ticketArrayList = ticketArrayList;
        notifyDataSetChanged();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private final PatientViewBinding patientViewBinding;

        public MyHolder(@NonNull PatientViewBinding patientViewBinding) {
            super(patientViewBinding.getRoot());

            this.patientViewBinding = patientViewBinding;
            patientViewBinding.executePendingBindings();
        }

    }
}
