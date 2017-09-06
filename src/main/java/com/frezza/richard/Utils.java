package com.frezza.richard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public final class Utils {
    
    public static final Long parseLong(String value) {
        return isEmpty(value) ? null : Long.parseLong(value);
    }
    
    public static final boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    public static final boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }
    
    public static final Map<String, String> parseMap(HttpServletRequest req) {
        Map<String, String> dados = new HashMap<>();
        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String key = params.nextElement();
            dados.put(key, req.getParameter(key));
        }
        return dados;
    }

    public static Date parseDate(String value) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlDate = new java.sql.Date(sdf.parse(value).getTime());
            return isEmpty(value) ? null :  sqlDate;
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Timestamp parseTimeStamp(String value) {
        try {
        	String data = value.replace("T", " ");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(sdf.parse(data).getTime());
            return isEmpty(data) ? null :  sqlDate;
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String parseDateBrasil(Date data) {
		SimpleDateFormat fromClient = new SimpleDateFormat("dd/MM/yyyy");
		return fromClient.format(data);
	   
    }
   
       
    public static String parseSituacaoCompetencia(String value){
    	if("A".equals(value)){
    		return "Aberto";
    	}else{
    		return "Encerrado";
    	}
    }
    
    public static String parseTipoPessoa(int value){
    	if(value==1){
    		return "Colaborador";
    	}else{
    		return "Cliente";
    	}
    }
    
    public static Double parseValorProcedimento(String value){
    	if(isEmpty(value)){
    		return 0.0;
    	}
    	value = value.replace(".","");
    	value = value.replace(",","." );
    	return Double.parseDouble(value);
    }
 
}
