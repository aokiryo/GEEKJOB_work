/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.*;

/**
 *
 * @author ryo
 */
public class User extends Human {

    /*
    *:@Override
    *手札の数値を合計して返す
     */
    public int open() {
        //戻り値
        int sum = 0;

        //1が含まれているかの判定用
        boolean x = false;

        //1があればそれを抜き出す（1回だけ）
        for (int i = 0; i < this.myCards.size(); i++) {
            if (this.myCards.contains(1)) {
                this.myCards.remove(this.myCards.indexOf(1));
                x = true;
                break;
            }
        }

        //絵札は10に置き換え
        for (int i = 0; i < this.myCards.size(); i++) {
            for (int n = 11; n < 14; n++) {
                if (this.myCards.contains(n)) {
                    this.myCards.set(this.myCards.indexOf(n), 10);
                }
            }
        }

        //抜き出された1以外の数値を合計
        for (Integer plus : this.myCards) {
            sum += plus;
        }

        //抜き出された1の処理
        if (x == true) {
            if (sum > 10) {
                sum += 1;
                this.myCards.add(1);
            } else {
                sum += 11;
                this.myCards.add(1);
            }
        }
        return sum;
    }

    /*
    *:@Override
    *引いたカードを手札に加える（加算処理はしない）
     */
    public void setCard(ArrayList<Integer> x) {
        for (Integer n : x) {
            this.myCards.add(n);
        }
    }

    /*
    *:@Override
    *手札の合計が17未満ならばカードを引く
    *ディーラーと同じくらいを狙い、負けないことを優先する
     */
    public boolean checkSum() {
        boolean draw;
        if (open() < 17) {
            draw = true;
        } else {
            draw = false;
        }
        return draw;
    }

}
