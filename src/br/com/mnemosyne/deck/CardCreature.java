/*     */ package br.com.mnemosyne.deck;
/*     */ 
/*     */ public class CardCreature
/*     */ {
/*     */   private int id;
/*     */   private String name;
/*     */   private String information;
/*     */   private String cost;
/*     */   private String power;
/*     */   private String defense;
/*     */   private String txtAbility;
/*     */   private String target;
/*     */   private String source;
/*     */   private String oper;
/*     */   private String no;
/*     */   private boolean gravado;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  20 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int id) {
/*  24 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  28 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  32 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  36 */     return this.information;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String information) {
/*  40 */     this.information = information;
/*     */   }
/*     */ 
/*     */   public String getCusto()
/*     */   {
/*  45 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void setCusto(String cost) {
/*  49 */     this.cost = cost;
/*     */   }
/*     */ 
/*     */   public String getForca() {
/*  53 */     return this.power;
/*     */   }
/*     */ 
/*     */   public void setForca(String power) {
/*  57 */     this.power = power;
/*     */   }
/*     */ 
/*     */   public String getDefesa() {
/*  61 */     return this.defense;
/*     */   }
/*     */ 
/*     */   public void setDefesa(String defense) {
/*  65 */     this.defense = defense;
/*     */   }
/*     */ 
/*     */   public String getHabilidade()
/*     */   {
/*  70 */     return this.txtAbility;
/*     */   }
/*     */ 
/*     */   public void setHabilidade(String txtAbility) {
/*  74 */     this.txtAbility = txtAbility;
/*     */   }
/*     */ 
/*     */   public String getTarget() {
/*  78 */     return this.target;
/*     */   }
/*     */ 
/*     */   public void setTarget(String target) {
/*  82 */     this.target = target;
/*     */   }
/*     */ 
/*     */   public String getOrigemHab() {
/*  86 */     return this.source;
/*     */   }
/*     */ 
/*     */   public void setOrigemHab(String source) {
/*  90 */     this.source = source;
/*     */   }
/*     */ 
/*     */   public String getOperHab() {
/*  94 */     return this.oper;
/*     */   }
/*     */ 
/*     */   public void setOperHab(String oper) {
/*  98 */     this.oper = oper;
/*     */   }
/*     */ 
/*     */   public String getValorOper() {
/* 102 */     return this.no;
/*     */   }
/*     */ 
/*     */   public void setValorOper(String no) {
/* 106 */     this.no = no;
/*     */   }
/*     */   public boolean isGravado() {
/* 109 */     return this.gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(boolean gravado) {
/* 113 */     this.gravado = gravado;
/*     */   }
/*     */ 
/*     */   public void setGravado(String gravado) {
/* 117 */     if (gravado.equalsIgnoreCase("SIM"))
/* 118 */       this.gravado = true;
/* 119 */     else if (gravado.equalsIgnoreCase("NAO"))
/* 120 */       this.gravado = false;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 125 */     StringBuffer st = new StringBuffer();
/* 126 */     st.append("Codigo: " + getId()).append(" gravado: " + isGravado()).append("\n").append("Nome: " + getNome()).append("\n").append("Informacoeees: " + getInformacoes()).append("\n").append("Custo: " + getCusto()).append("\n").append("Forca: " + getForca()).append("\n").append("Defesa: " + getDefesa()).append("\n").append("Habilidade: " + getHabilidade()).append("\n").append("Origem da Habilidade: " + getOrigemHab()).append("\n").append("Operacao da Habilidade: " + getOperHab()).append("\n").append("Valor de Operacao: " + getValorOper()).append("\n");
/*     */ 
/* 147 */     return st.toString();
/*     */   }
/*     */ 
/*     */   public void setType(Object selectedItem) {
/* 151 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 155 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.deck.CardCreature
 * JD-Core Version:    0.6.2
 */