package br.com.deckbuilder.model;


public class Action
{
  public String action1;
  public Attr attr1;
  
  public String action2;
  public Attr attr2;
  
  public String action3;
  public Attr attr3;
  
  private static Action singleton;
  
  public static Action getInstance()
/*      */   {
/*   13 */     if (singleton == null) {
/*   14 */       singleton = new Action();
/*      */     }
/*      */ 
/*   17 */     return singleton;
/*      */   }
}
