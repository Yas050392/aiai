/*    */ package br.com.mnemosyne.events;
/*    */ 
/*    */ import br.com.mnemosyne.beans.CharacterCard;
/*    */ import br.com.mnemosyne.beans.Game;
/*    */ import br.com.mnemosyne.console.Comandos;
/*    */ import br.com.mnemosyne.interfaces.CallbackUserInterface;
/*    */ 
/*    */ public class BlockEvent extends Event
/*    */   implements Subscriber
/*    */ {
/*    */   public void inform(Event event)
/*    */   {
/* 13 */     if (Game.getInstance().canDefineBlocker().booleanValue()) {
/* 14 */       CallbackUserInterface cInterface = Comandos.getInstance();
/* 15 */       CharacterCard target = cInterface.defineBlocker();
/* 16 */       if (target != null)
/* 17 */         ((AttackEvent)event).setTarget(target);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void run(Object o)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.events.BlockEvent
 * JD-Core Version:    0.6.2
 */