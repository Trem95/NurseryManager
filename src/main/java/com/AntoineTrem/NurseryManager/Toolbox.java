package com.AntoineTrem.NurseryManager;

public class Toolbox {
    public static java.sql.Date convertToSqlDate(java.time.LocalDate date)
    {
        return java.sql.Date.valueOf(date);
    }
}
