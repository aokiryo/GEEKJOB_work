/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author ryo
 */
public class BlackJack {

    public static void main(String[] args) {

        //プレイヤーとディーラーのインスタンス生成
        Dealer dealer = new Dealer();
        User player = new User();

        //スタンド宣言
        int playerStand = 0;
        int dealerStand = 0;

        //結果
        String result;

        //アナウンス
        System.out.println("ゲームを開始します");

        //ディーラーがカードを配る
        dealer.setCard(dealer.deal());
        player.setCard(dealer.deal());

        //ディーラーの手札公開
        System.out.println("ディーラーのアップカードは" + dealer.myCards.get(0) + "です");
                
        /*
        *プレイヤーは手札の合計とアップカードによってヒットするか判断する
        *
        *ディーラーは手札の合計が17以上になるまでヒットする
         */
        while (playerStand == 0 || dealerStand == 0) {
            //プレイヤーのターン
            if (playerStand == 1) {
            } else if (player.checkSum() == false) {
                //スタンド
                playerStand = 1;
                System.out.println("プレイヤーはスタンドしました");
            } else if (player.myCards.contains(1)) {
                //ヒット
                player.setCard(dealer.hit());
                System.out.println("プレイヤーはヒットしました");
            } else if (dealer.myCards.get(0) < 7) {
                //ヒット
                player.setCard(dealer.hit());
                System.out.println("プレイヤーはヒットしました");
            } else if (player.open() >= 12) {
                //スタンド
                playerStand = 1;
                System.out.println("プレイヤーはスタンドしました");
            } else {
                //ヒット
                player.setCard(dealer.hit());
                System.out.println("プレイヤーはヒットしました");
            }

            //ディーラーのターン
            if (dealerStand == 1) {
            } else if (dealer.checkSum() == false) {
                //スタンド
                dealerStand = 1;
                System.out.println("ディーラーはスタンドしました");
            } else {
                //ヒット
                dealer.setCard(dealer.hit());
                System.out.println("ディーラーはヒットしました");
            }

        }

        //勝敗判定
        if (player.open() > 21) {
            result = "ディーラーの勝利です";
        } else if (player.open() == 21 && !(dealer.open() == 21)) {
            result = "プレイヤーの勝利です";
        } else if (player.open() == 21 && dealer.open() == 21) {
            result = "引き分けです";
        } else if (dealer.open() > 21) {
            result = "プレイヤーの勝利です";
        } else if (dealer.open() == 21) {
            result = "ディーラーの勝利です";
        } else if (dealer.open() > player.open()) {
            result = "ディーラーの勝利です";
        } else if (dealer.open() == player.open()) {
            result = "引き分けです";
        } else {
            result = "プレイヤーの勝利です";
        }

        //結果発表
        System.out.println("結果発表です");
        System.out.println("プレイヤーのスコアは"+player.open());
        System.out.println("ディーラーのスコアは"+dealer.open());
        if ((player.open() == 21 && player.myCards.size() == 2)
                || (dealer.open() == 21 && dealer.myCards.size() == 2)) {
            System.out.println("ナチュラル21で" + result);
        }else{
            System.out.println(result);
        }

    }

}

