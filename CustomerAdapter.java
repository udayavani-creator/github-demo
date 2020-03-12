package com.example.creativeapp;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

    public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
        ArrayList<Customer> arrayList = new ArrayList<>();

        public CustomerAdapter(ArrayList<Customer> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public CustomerAdapter.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new CustomerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomerViewHolder CustomerViewHolder, int i) {
            Customer data =arrayList.get(i);
            CustomerViewHolder.customerid.setText(data.getCustomerid());
            CustomerViewHolder.customername.setText(data.getCustomername());
            CustomerViewHolder.customermail.setText(data.getCustomermail());
            CustomerViewHolder.userid.setText(data.getUserdetails().getUserid());
            CustomerViewHolder.password.setText(data.getUserdetails().getPassword());
            CustomerViewHolder.role.setText(data.getUserdetails().getRole());
            CustomerViewHolder.bid.setText(data.getBillingAddress().getBid());
            CustomerViewHolder.houseno.setText(data.getBillingAddress().getHouseno());
            CustomerViewHolder.street.setText(data.getBillingAddress().getStreet());
            CustomerViewHolder.city.setText(data.getBillingAddress().getCity());
            CustomerViewHolder.state.setText(data.getBillingAddress().getState());
            CustomerViewHolder.pincode.setText(data.getBillingAddress().getPincode());


        }


        @Override
        public int getItemCount() {
            return arrayList.size();    }

        public class  CustomerViewHolder extends RecyclerView.ViewHolder {

            TextView customerid,customername,customermail,userid,password,role,bid,houseno,street,city,state,pincode;


            public CustomerViewHolder(@NonNull View itemView) {
                super(itemView);
                customerid = itemView.findViewById(R.id.customerid);
                customername= itemView.findViewById(R.id.customername);
                customermail=itemView.findViewById(R.id.customermail);
                userid=itemView.findViewById(R.id.userid);
                password=itemView.findViewById(R.id.password);
                role=itemView.findViewById(R.id.role);
                bid=itemView.findViewById(R.id.bid);
                houseno=itemView.findViewById(R.id.houseno);
                street=itemView.findViewById(R.id.street);
                city= itemView.findViewById(R.id.city);
                state =itemView.findViewById(R.id.state);
                pincode=itemView.findViewById(R.id.pincode);










            }
        }

    }


