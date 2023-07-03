package com.example.demopropertyfacilityjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demopropertyfacilityjava.R;
import com.example.demopropertyfacilityjava.models.Facility;

import java.util.List;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder> {

    private List<Facility> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public FacilityAdapter(Context context, List<Facility> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.facility_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Facility facility = mData.get(position);
        holder.name.setText(facility.getName());
        holder.id.setText(facility.getFacilityId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    Facility getItem(int id) {
        return mData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, id;

        ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.text_view_facility_id);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}

