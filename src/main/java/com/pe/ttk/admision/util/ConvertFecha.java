package com.pe.ttk.admision.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertFecha {

    public Date fechaStringToSqlDate(String fecha){

        Date dataFormateada;
        dataFormateada =  Date.valueOf(fecha);

        return dataFormateada;

    }
}
