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
public class Dealer extends Human {

    //山札
    protected ArrayList<Integer> cards = new ArrayList<Integer>();

    //初期処理
    public Dealer() {
        for (int n = 0; n < 4; n++) {
            for (int i = 1; i < 14; i++) {
                cards.add(i);
            }
        }
    }

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
    *引いたカードを手札に加える
     */
    public void setCard(ArrayList<Integer> x) {
        for (Integer n : x) {
            this.myCards.add(n);
        }
    }

    /*
    *:@Override
    *手札の合計が17未満ならばカードを引く
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

    //ディール
    public ArrayList<Integer> deal() {
        ArrayList<Integer> firstHands = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) {
            Random rand = new Random();
            Integer n = rand.nextInt(cards.size());
            firstHands.add(cards.get(n));
            cards.remove(n);
        }
        return firstHands;
    }

    //ヒット
    public ArrayList<Integer> hit() {
        ArrayList<Integer> drawCard = new ArrayList<Integer>();

        Random rand = new Random();
        Integer n = rand.nextInt(cards.size());
        drawCard.add(cards.get(n));
        cards.remove(n);
        return drawCard;
    }

}
