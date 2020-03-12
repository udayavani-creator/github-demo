package com.example.creativeapp;

public class Customer {
    private String customerid;
    private String customername;
    private String customermail;
    private UserDetails userdetails;
    private BillingAddress billingAddress;

    public Customer(String customerid, String customername, String customermail, UserDetails userdetails, BillingAddress billingAddress) {
        this.customerid = customerid;
        this.customername = customername;
        this.customermail = customermail;
        this.userdetails = userdetails;
        this.billingAddress = billingAddress;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomermail() {
        return customermail;
    }

    public void setCustomermail(String customermail) {
        this.customermail = customermail;
    }

    public UserDetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
