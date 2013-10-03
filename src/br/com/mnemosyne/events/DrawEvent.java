/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.Player;
/*    */ 
/*    */ public class DrawEvent extends Event
/*    */ {
/*    */   public void run(Player p)
/*    */   {
/*  8 */     p.draw(1);
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/* 17 */     if ((o instanceof Player))
/* 18 */       run((Player)o);
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.DrawEvent
 * JD-Core Version:    0.6.2
 */