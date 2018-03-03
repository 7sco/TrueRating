package com.example.franciscoandrade.truerating.controller;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franciscoandrade.truerating.R;
import com.example.franciscoandrade.truerating.model.InspectionResultsModel;

/**
 * Created by melg on 3/3/18.
 */

public class GradingViewHolder extends RecyclerView.ViewHolder {
    private TextView restaurantName;
    private TextView address;
    private TextView phoneNumber;
    private TextView letterGrade;
    private String streetAddress;
    private String businessNumber;
    private String letter;


    public GradingViewHolder(View itemView) {
        super(itemView);

        restaurantName = itemView.findViewById(R.id.restaurant_name);
        address = itemView.findViewById(R.id.restaurant_address);
        phoneNumber = itemView.findViewById(R.id.telephone_number);
        letterGrade = itemView.findViewById(R.id.letter_grade);

    }
    public void onbind(InspectionResultsModel inspectionResultsModel){


        streetAddress = inspectionResultsModel.getBuilding()+ " " + inspectionResultsModel.getStreet()
                + "\n" + inspectionResultsModel.getBoro() + " , " + inspectionResultsModel.getZipcode();

        businessNumber = inspectionResultsModel.getPhone();

        letter = inspectionResultsModel.getGrade();

        restaurantName.setText(inspectionResultsModel.getDba());
        address.setText(streetAddress);
        phoneNumber.setText(businessNumber);
        if(inspectionResultsModel.getGrade()==null){
            letter= "Pending";
        }
        letterGrade.setText(letter);
    }
}
