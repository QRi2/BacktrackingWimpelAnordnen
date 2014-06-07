package wimpel;

import java.util.ArrayList;
import java.util.List;

public class Wimpel {
  private List<int[]> lsg = new ArrayList<int[]>();
  private int[] modAry;
  private int laenge;
  private int anzahl;
  
  public Wimpel(int anzahlWimpel,int anzahlFarben){
    this.laenge = anzahlWimpel;
    this.anzahl = anzahlFarben;
    modAry = new int[anzahlWimpel];
  }
  
  public void solveWimpel(int depth){
    for(int i = 1; i <=anzahl; i++){
      if(depth == 0 || modAry[depth-1] != i){
        modAry[depth] = i;
      }else{
        continue;
      }
      if(depth+1 < this.laenge){
        solveWimpel(depth+1); 
      }else{
        lsg.add(modAry.clone());
      }
    }
  }
  
  public void showLsg(){
    System.out.println("Anzahl Lösungen: " + lsg.size());
    int[] ary = new int[laenge];
    if(lsg.size() < 11){
      for(int i = 0; i < lsg.size(); i++){
        ary = lsg.get(i);
        for(int j = 0; j < ary.length; j++){
          System.out.print(ary[j]);
          if(j != ary.length -1){
            System.out.print(", ");
          }
        }
        System.out.println("");
      }
    }else{
      for(int i = 0; i < 3; i++){
        ary = lsg.get(i);
        for(int j = 0; j < ary.length; j++){
          System.out.print(ary[j]);
          if(j != ary.length -1){
            System.out.print(", ");
          }
        }
        System.out.println("");
      }
    }
  }  
}
