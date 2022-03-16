/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.Serializable;

/**
 *
 * @author Trisha
 */
public class Community implements Serializable {

private static final long serialVersionUID = 1L;

String community;
String city;

    public Community(String community, String city) {
        this.community = community;
        this.city = city;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    
}
