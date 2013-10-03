/*    */ package br.com.mnemosyne.deck;
/*    */ 
/*    */ public class Deck
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private String information;
/*    */   private String strategy;
/*    */   private String qtdCards;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 15 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(int id) {
/* 19 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getNome() {
/* 23 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setNome(String name) {
/* 27 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getInformacoes() {
/* 31 */     return this.information;
/*    */   }
/*    */ 
/*    */   public void setInformacoes(String information) {
/* 35 */     this.information = information;
/*    */   }
/*    */ 
/*    */   public String getStrategy() {
/* 39 */     return this.strategy;
/*    */   }
/*    */ 
/*    */   public void setStrategy(String strategy) {
/* 43 */     this.strategy = strategy;
/*    */   }
/*    */ 
/*    */   public String getQtdCards() {
/* 47 */     return this.qtdCards;
/*    */   }
/*    */ 
/*    */   public void setQtdCards(String qtdCards) {
/* 51 */     this.qtdCards = qtdCards;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 55 */     StringBuffer st = new StringBuffer();
/* 56 */     st.append("Codigo: " + getId()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Estrategia: " + getStrategy()).append("\n").append("Quantidade de Cartas: " + getQtdCards()).append("\n");
/*    */ 
/* 66 */     return st.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.deck.Deck
 * JD-Core Version:    0.6.2
 */