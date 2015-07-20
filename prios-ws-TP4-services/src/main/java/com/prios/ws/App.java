package com.prios.ws;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Hello world!
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class App 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
}
