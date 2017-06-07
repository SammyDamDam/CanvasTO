package com.example.samanthayao.canvasto;

/**
 * Created by Arthur Lin on 2017-06-08.
 */

public class Products {

    private String _username;
    private String _productname;

    public Products() {

    }

    public Products(String productname) {
        this._productname = productname;
    }
    //setters to give user object an id and/or productname
    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }
    //getters to retrieve id/productname
    public String get_username() {
        return _username;
    }

    public String get_productname() {
        return _productname;
    }
}
