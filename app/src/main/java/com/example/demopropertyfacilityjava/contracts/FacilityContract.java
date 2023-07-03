package com.example.demopropertyfacilityjava.contracts;

import com.example.demopropertyfacilityjava.models.PropertyResponseModel;

public class FacilityContract {

    public interface View {
        void onAPIFailed(String message);

        void onAPISuccess(PropertyResponseModel propertyResponseModel);

    }


    public interface Presenter {
        void callGetPropertyAPI();

        void attachView(FacilityContract.View view);
    }
}