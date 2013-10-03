package br.com.deckbuilder.model;

public class Attr
{
  public String attr1;
  public Target target1;
  public String no1;
  
    public String attr2;
  public Target target2;
  public String no2;
  
    public String attr3;
  public Target target3;
  public String no3;
  
    private static Attr singleton;
    
  public static Attr getInstance()
/*      */   {
/*   13 */     if (singleton == null) {
/*   14 */       singleton = new Attr();
/*      */     }
/*      */ 
/*   17 */     return singleton;
/*      */   }
}

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.model.Attr
 * JD-Core Version:    0.6.2
 */