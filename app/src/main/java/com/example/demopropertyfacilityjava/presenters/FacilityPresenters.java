package com.example.demopropertyfacilityjava.presenters;

import android.util.Log;

import com.example.demopropertyfacilityjava.contracts.FacilityContract;
import com.example.demopropertyfacilityjava.models.PropertyResponseModel;
import com.example.demopropertyfacilityjava.retrofit.APIClient;
import com.example.demopropertyfacilityjava.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacilityPresenters implements FacilityContract.Presenter {

    private FacilityContract.View mainView;
    private ApiInterface apiInterface;

    @Override
    public void attachView(FacilityContract.View view) {
        this.mainView = view;
        apiInterface = APIClient.getRetrofitClient().create(ApiInterface.class);
    }

    @Override
    public void callGetPropertyAPI() {
        Call<PropertyResponseModel> call = apiInterface.getProperties();
        call.enqueue(new Callback<PropertyResponseModel>() {
            @Override
            public void onResponse(Call<PropertyResponseModel> call, Response<PropertyResponseModel> response) {
                if (response.code() == 200) {
                    mainView.onAPISuccess(response.body());
                } else {
                    mainView.onAPIFailed("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<PropertyResponseModel> call, Throwable t) {
                Log.e("inside", "Something went wrong");
            }
        });
    }
}
