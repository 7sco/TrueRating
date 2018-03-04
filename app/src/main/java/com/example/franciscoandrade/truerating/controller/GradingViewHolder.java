package com.example.franciscoandrade.truerating.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franciscoandrade.truerating.R;
import com.example.franciscoandrade.truerating.model.InspectionResultsModel;
import com.example.franciscoandrade.truerating.view.BusinessDetail;

/**
 * Created by melg on 3/3/18.
 */

public class GradingViewHolder extends RecyclerView.ViewHolder {
    private TextView restaurantName;
    private TextView address;
    private TextView phoneNumber;
    private TextView letterGrade, letter_gradePending;
    private String streetAddress;
    private String businessNumber;
    private String letter;
    private String pendingGrade;
    private String name;
    private LinearLayout cardLayout;
    private Context context;


    public GradingViewHolder(View itemView) {
        super(itemView);

        restaurantName = itemView.findViewById(R.id.restaurant_name);
        address = itemView.findViewById(R.id.restaurant_address);
        phoneNumber = itemView.findViewById(R.id.telephone_number);
        letterGrade = itemView.findViewById(R.id.letter_grade);
        letter_gradePending = itemView.findViewById(R.id.letter_gradePending);
        cardLayout = itemView.findViewById(R.id.iv_card);

    }

    public void onbind(final InspectionResultsModel inspectionResultsModel) {

        name = inspectionResultsModel.getDba();
        streetAddress = inspectionResultsModel.getBuilding() + " " + inspectionResultsModel.getStreet()
                + "\n" + inspectionResultsModel.getBoro() + " , " + inspectionResultsModel.getZipcode();

        businessNumber = inspectionResultsModel.getPhone();

        letter = inspectionResultsModel.getGrade();
        pendingGrade = "Pending";

        restaurantName.setText(name);
        address.setText(streetAddress);
        phoneNumber.setText(businessNumber);
        if (inspectionResultsModel.getGrade() == null || inspectionResultsModel.getGrade().equals(pendingGrade)) {
            letter_gradePending.setVisibility(View.VISIBLE);
            letterGrade.setVisibility(View.GONE);

        } else {
            letter_gradePending.setVisibility(View.GONE);
            letterGrade.setVisibility(View.VISIBLE);

        }
        letterGrade.setText(letter);

        cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), BusinessDetail.class);
                Bundle bundle = new Bundle();

                bundle.putString("code",inspectionResultsModel.getViolation_code());
                bundle.putString("desc",inspectionResultsModel.getViolation_description());
                bundle.putString("critical",inspectionResultsModel.getCritical_flag());
                bundle.putString("address", streetAddress);
                bundle.putString("phone", businessNumber);
                bundle.putString("name", name);
                if (letter != "Not Yet Implemented") {
                    bundle.putString("grade", pendingGrade);
                }
                if (letter != null) {
                    bundle.putString("grade", letter);
                } else {
                    bundle.putString("grade", pendingGrade);
                }

                intent.putExtras(bundle);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
