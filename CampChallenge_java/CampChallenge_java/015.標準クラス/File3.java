/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigInteger;

/**
 *
 * @author ryo
 */
public class File3 {

    public static void main(String[] args) {
        //1から100の間に含まれる素数を表示する

        //処理開始、終了時刻を記録
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 HH時 mm分 ss秒");
        String fd = sdf.format(d);

        try {
            //ログファイル
            File fp = new File("C:\\Users\\ryo\\Documents\\log.txt");
            fp.createNewFile();
            FileWriter fw = new FileWriter(fp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("処理を開始します");
            bw.newLine();
            bw.write(fd);
            bw.newLine();

            //1から100の間に含まれる素数をコンソール上に表示
            for (int i = 1; i < 100; i++) {
                BigInteger bi = new BigInteger(String.valueOf(i));
                if (bi.isProbablePrime(100000)) {
                    System.out.println(i);
                }
            }
            bw.write("処理を終了します");
            bw.newLine();
            bw.write(fd);
            bw.newLine();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
