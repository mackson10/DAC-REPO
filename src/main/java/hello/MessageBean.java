package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String msg;
    private String byeMsg;

    private enum Greetings {
        PT("Olá", "Bom dia", "Boa tarde", "Boa noite", "Tchau"),
        EN("Hello", "Good morning", "Good afternoon", "Good night", "Goodbye"),
        DE("Hallo", "Guten Morgen", "Guten Nachmittag", "Gute Nacht", "Auf Wiedersehen"),
        FR("Salut", "Bonjuor", "Bon après-midi", "Bonne nuit", "Au revoir"),
        NE("Hoi", "Goedemorgen", "Goedemiddag", "Goedenacht", "Vaarwel"),
        RU("Privet", "Dobroye utro", "Dobryy den'", "spokoynoy nochi", "Do svidaniya");

        private String hello;
        private String morning;
        private String afternoon;
        private String night;
        private String bye;

        Greetings(String hello, String morning, String afternoon, String night, String bye) {
            this.hello = hello;
            this.morning = morning;
            this.afternoon = afternoon;
            this.night = night;
            this.bye = bye;
        }
    }

    public MessageBean() {
    }
    
    public String getMsg() {  
        return msg;
    }
    
    public void setMsg(String lang) {
        msg = this.getHelloGreeting(lang) + ", " + this.getTimeGreeting(lang);
    }
    
    public String getByeMsg() {
        return byeMsg;
    }
    
    public void setByeMsg(String lang) {
        lang = lang.toUpperCase();
        byeMsg = Greetings.valueOf(lang).bye;
    }
    
    public String getHelloGreeting(String lang) {
        lang = lang.toUpperCase();
        return Greetings.valueOf(lang).hello;
    }

    public String getTimeGreeting(String lang) {
        lang = lang.toUpperCase();
        int hourOfNow = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hourOfNow >= 0 && hourOfNow < 12) {
            return Greetings.valueOf(lang).morning;
        } else if (hourOfNow >= 12 && hourOfNow < 18) {
            return Greetings.valueOf(lang).afternoon;
        } else {
            return Greetings.valueOf(lang).night;
        }
    }
}
