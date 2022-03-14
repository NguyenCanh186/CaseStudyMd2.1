package model;

import controller.ManagerLibrary;
import storage.LentBookFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import static controller.ManagerLibrary.lentBookFile;


public class Receipts {

    public double code;

    public double getCode() {
        double a = Math.random();
        return a * 100000 + 1;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public  String toString(){
        return "Mã phiếu thu: " + getCode() ;

    }
}
