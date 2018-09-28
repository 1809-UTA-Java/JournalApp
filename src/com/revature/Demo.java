package com.revature;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class Demo {
    public static void main(String[] args) {
        Journal journal = new Journal();
        journal.openJournal();
        journal.closeJournal();
    }
}