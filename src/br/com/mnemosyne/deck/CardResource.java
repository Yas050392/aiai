/*     */ package br.com.mnemosyne.deck;
/*     */ 
/*     */ public class CardResource
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
/*  16 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id) {
/*  20 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  24 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  28 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  32 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String txtAbility) {
/*  36 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getTarget()
/*     */   {
/*  41 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  45 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public String getHabilidade() {
/*  49 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setHabilidade(String txtAbility) {
/*  53 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  57 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  61 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getOperHab() {
/*  65 */     return this.oper;
/*     */   }
/*     */ 
/*     */   public void setOperHab(String oper) {
/*  69 */     this.oper = oper;
/*     */   }
/*     */ 
/*     */   public boolean isGravado() {
/*  73 */     return this.gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(boolean gravado) {
/*  77 */     this.gravado = gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(String gravado) {
/*  81 */     if (gravado.equalsIgnoreCase("SIM"))
/*  82 */       this.gravado = true;
/*  83 */     else if (gravado.equalsIgnoreCase("NAO"))
/*  84 */       this.gravado = false;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  89 */     StringBuffer st = new StringBuffer();
/*  90 */     st.append("Codigo: " + getId()).append(" gravado: " + isGravado()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Habilidade: " + getHabilidade()).append("\n").append("Origem da Habilidade: " + getTarget()).append("\n").append("Operacao da Habilidade: " + getOperHab()).append("\n").append("Valor de Operacao: " + getType()).append("\n");
/*     */ 
/* 105 */     return st.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.deck.CardResource
 * JD-Core Version:    0.6.2
 */