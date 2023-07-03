package com.example.demopropertyfacilityjava.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demopropertyfacilityjava.R;
import com.example.demopropertyfacilityjava.adapters.FacilityAdapter;
import com.example.demopropertyfacilityjava.contracts.FacilityContract;
import com.example.demopropertyfacilityjava.models.PropertyResponseModel;
import com.example.demopropertyfacilityjava.presenters.FacilityPresenters;

public class MainActivity extends AppCompatActivity implements FacilityAdapter.ItemClickListener, FacilityContract.View {

    private FacilityContract.Presenter facilityPresenters;
    private FacilityAdapter facilityAdapter;
    private RecyclerView recycleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView = findViewById(R.id.property_recycle_view);
        facilityPresenters = new FacilityPresenters();
        facilityPresenters.attachView(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        facilityPresenters.callGetPropertyAPI();
    }


    private void setData(PropertyResponseModel propertyResponseModel) {

        recycleView.setLayoutManager(new LinearLayoutManager(this));
        facilityAdapter = new FacilityAdapter(this, propertyResponseModel.getFacilities());
        facilityAdapter.setClickListener(this);
        recycleView.setAdapter(facilityAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onAPIFailed(String message) {
        Log.d("inside", message);
    }

    @Override
    public void onAPISuccess(PropertyResponseModel propertyResponseModel) {
        setData(propertyResponseModel);
    }
}
