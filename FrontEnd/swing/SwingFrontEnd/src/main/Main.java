/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
/**
 *
 * @author jonathan
 */
public class Main {

    public static void main(String[] args){
        
        String obj= "Hola";
        System.out.println(System.identityHashCode(obj));
        
        Map<String,Object> map= new HashMap();
        map.put("Hola", obj);
        String a=(String)map.get("Hola");
         System.out.println(System.identityHashCode(a));
        
    }
    
    
}
