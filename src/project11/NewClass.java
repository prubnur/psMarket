/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author isaluja1811
 */
public class NewClass {
    public static void main (String[] args) {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateformat.format(cal.getTime()));
    }
    
}
