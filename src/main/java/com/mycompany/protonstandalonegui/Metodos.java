/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.protonstandalonegui;

/**
 *
 * @author pcdebian
 */
public class Metodos {
    public static String quitaextension(String texto)
    {
        int cont = texto.length() -1;
        while(texto.charAt(cont)!='.')
        { 
            cont--;
        }
        return texto.substring(0, cont);
    }
}
