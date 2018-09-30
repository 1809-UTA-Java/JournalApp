package com.revature;

import java.util.*;
import java.io.Serializable;
/**
* A journal that serialized an object 
* SerializableJournal has entry that is 
* contained in a jlog property, short for journal log
*
* @author Leonardo De Leon
*
*/
public class Journal implements Serializable {

    private Hashtable<String, String> log = new Hashtable<>();

    public Journal (String date, String entry) {
        this.log.put(date,entry);
    }

}