package com.solvd.gadgets.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class MyAdapter extends XmlAdapter <String, LocalDate >{
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return null;
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return null;
    }
}
