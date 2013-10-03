package br.com.deckbuilder.model;

public class Target
{
    public String target1;
    
    public String target2;
    
    public String target3;
    
      private static Target singleton;
      
        public static Target getInstance()
/*      */   {
/*   13 */     if (singleton == null) {
/*   14 */       singleton = new Target();
/*      */     }
/*      */ 
/*   17 */     return singleton;
/*      */   }
}

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.deckbuilder.model.Target
 * JD-Core Version:    0.6.2
 */