/*     */ package br.com.mnemosyne.deck;
/*     */ 
/*     */ public class CardMagic
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String txtAbility;
/*     */   private String target;
/*     */   private String oper;
/*     */   private String type;
/*     */   private boolean gravado;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  15 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id) {
/*  19 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  23 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  27 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  31 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String txtAbility) {
/*  35 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getTarget()
/*     */   {
/*  40 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  44 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public String getHabilidade() {
/*  48 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setHabilidade(String txtAbility) {
/*  52 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  56 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  60 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getOperHab() {
/*  64 */     return this.oper;
/*     */   }
/*     */ 
/*     */   public void setOperHab(String oper) {
/*  68 */     this.oper = oper;
/*     */   }
/*     */ 
/*     */   public boolean isGravado() {
/*  72 */     return this.gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(boolean gravado) {
/*  76 */     this.gravado = gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(String gravado) {
/*  80 */     if (gravado.equalsIgnoreCase("SIM"))
/*  81 */       this.gravado = true;
/*  82 */     else if (gravado.equalsIgnoreCase("NAO"))
/*  83 */       this.gravado = false;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  88 */     StringBuffer st = new StringBuffer();
/*  89 */     st.append("Codigo: " + getId()).append(" gravado: " + isGravado()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Habilidade: " + getHabilidade()).append("\n").append("Alvo da Habilidade: " + getTarget()).append("\n").append("Operacao da Habilidade: " + getOperHab()).append("\n").append("Tipo Habilidade: " + getType()).append("\n");
/*     */ 
/* 104 */     return st.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.deck.CardMagic
 * JD-Core Version:    0.6.2
 */