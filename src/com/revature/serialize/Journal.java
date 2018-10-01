package com.revature.serialize;

import java.util.*;
import java.io.Serializable;
/**
* A journal that serialized an object 
* SerializableJournalApp has acontent that is  
* contained in a Hashtable container
*
* @author Leonardo De Leon
*
*/
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;

    public Hashtable<String, String> contents = new Hashtable<>();

    public Journal (String date, String entry) {
        this.contents.put(date,entry);
    }

    public Journal () {}

    public Hashtable<String, String> getContents() {
        return this.contents;
    }

    public void addContents(String date, String entry) {
        this.contents.put(date,entry);
    }

}