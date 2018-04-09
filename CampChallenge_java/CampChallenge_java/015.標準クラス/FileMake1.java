/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.*;

/**
 *
 * @author ryo
 */
public class FileMake1 {

    public static void main(String[] args) {

        try {
            File fp = new File("C:\\Users\\ryo\\Documents\\introduction.txt");
            fp.createNewFile();
            FileWriter fw = new FileWriter(fp);
            fw.write("青木です。");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
