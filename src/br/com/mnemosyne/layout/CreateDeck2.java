/*    */ package br.com.mnemosyne.layout;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.EventQueue;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.UIManager.LookAndFeelInfo;
/*    */ import javax.swing.UnsupportedLookAndFeelException;
/*    */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*    */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*    */ 
/*    */ public class CreateDeck2 extends JFrame
/*    */ {
/*    */   private JLabel deckName;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */ 
/*    */   public CreateDeck2()
/*    */   {
/* 22 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 34 */     this.jLabel1 = new JLabel();
/* 35 */     this.deckName = new JLabel();
/* 36 */     this.jLabel2 = new JLabel();
/* 37 */     this.jLabel3 = new JLabel();
/*    */ 
/* 39 */     setDefaultCloseOperation(3);
/* 40 */     getContentPane().setLayout(new AbsoluteLayout());
/*    */ 
/* 42 */     this.jLabel1.setText("Criando o Deck");
/* 43 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(28, 20, -1, -1));
/*    */ 
/* 45 */     this.deckName.setText("deck");
/* 46 */     getContentPane().add(this.deckName, new AbsoluteConstraints(110, 20, -1, -1));
/*    */ 
/* 48 */     this.jLabel2.setText("Habilidades da carta");
/* 49 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(20, 60, -1, -1));
/*    */ 
/* 51 */     this.jLabel3.setText("carta");
/* 52 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(130, 60, -1, -1));
/*    */ 
/* 54 */     pack();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 67 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 68 */         if ("Nimbus".equals(info.getName())) {
/* 69 */           UIManager.setLookAndFeel(info.getClassName());
/* 70 */           break;
/*    */         }
/*    */     }
/*    */     catch (ClassNotFoundException ex) {
/* 74 */       Logger.getLogger(CreateDeck2.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (InstantiationException ex) {
/* 76 */       Logger.getLogger(CreateDeck2.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalAccessException ex) {
/* 78 */       Logger.getLogger(CreateDeck2.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (UnsupportedLookAndFeelException ex) {
/* 80 */       Logger.getLogger(CreateDeck2.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */ 
/* 85 */     EventQueue.invokeLater(new Runnable() {
/*    */       public void run() {
/* 87 */         new CreateDeck2().setVisible(true);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.layout.CreateDeck2
 * JD-Core Version:    0.6.2
 */