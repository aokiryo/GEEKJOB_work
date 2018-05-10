/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

//ルール①　java.io.Serializableのインポートと実装(シリアライズ可能であること)
import java.io.Serializable;

/**
 *
 * @author ryo
 */
public class TarotBeans implements Serializable{
    //ルール②　フィールドはカプセル化
    private String arcana;
    private String position;
    
    //ルール③　引数のないコンストラクタを持つ
    public TarotBeans(){}
    
    //ルール④　publicで命名規則に従ったgetterとsetterを持つ    
    public String getArcana(){
        return arcana;
    }
    
    public void setArcana(String arcana){
        this.arcana = arcana;
    }
    
    public String getPosition(){
        return position;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
    
}
