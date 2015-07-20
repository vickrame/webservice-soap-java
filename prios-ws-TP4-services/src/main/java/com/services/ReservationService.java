/**
 * 
 */
package com.services;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * @author vickrame
 *
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class ReservationService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7674225020306105493L;
	
	
	public boolean controleArgument(String dateStr){
		
		boolean ret = false;
		
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
		try {
			date = fmt.parse(dateStr);
	        Calendar cal = Calendar.getInstance();
			cal.setTime(date);
	        
			Calendar calCourante = Calendar.getInstance();
			calCourante.setTime(new Date());
			ret = calCourante.before(cal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
		
	}

}
