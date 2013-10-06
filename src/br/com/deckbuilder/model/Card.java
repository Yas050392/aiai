package br.com.deckbuilder.model;


public class Card {
    
            private String id;
/*     */   private String name;
/*     */   private String information;
/*     */   private String cost;
/*     */   private String type;
/*     */   private String power;
/*     */   private String defense;
            private String[] txtAbility1 = new String[3];
            private String[] txtAbility2 = new String[3];
            private String[] txtAbility3 = new String[3];
            private String[] txtAbility4 = new String[3];
            private String[] target = new String[3]; 
            private String[] event = new String[3];//atributo
            private String[] oper = new String[3];
            private String[] no = new String[3];
            
            private int qtd;
            private static Card singleton;
  
  public static Card getInstance()
/*      */   {
/*   13 */     if (singleton == null) {
/*   14 */       singleton = new Card();
/*      */     }
/*      */ 
/*   17 */     return singleton;
/*      */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/*  21 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  25 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getNome() {
/*  29 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setNome(String name) {
/*  33 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  37 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  41 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getInformacoes() {
/*  45 */     return this.information;
/*     */   }
/*     */ 
/*     */   public void setInformacoes(String information) {
/*  49 */     this.information = information;
/*     */   }
/*     */ 
/*     */   public String getCusto()
/*     */   {
/*  54 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void setCusto(String cost) {
/*  58 */     this.cost = cost;
/*     */   }
/*     */ 
/*     */   public String getForca() {
/*  62 */     return this.power;
/*     */   }
/*     */ 
/*     */   public void setForca(String power) {
/*  66 */     this.power = power;
/*     */   }
/*     */ 
/*     */   public String getDefesa() {
/*  70 */     return this.defense;
/*     */   }
/*     */ 
/*     */   public void setDefesa(String defense) {
/*  74 */     this.defense = defense;
/*     */   }


/*     */   public int getQtd()
/*     */   {
/*  21 */     return this.qtd;
/*     */   }
/*     */ 
/*     */   public void setQtd(int qtd) {
/*  25 */     this.qtd = qtd;
/*     */   }

 // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setOperItem(String operItem,int index) {  
        this.oper[index] = operItem;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getOperItem(int index) {  
        return oper[index];  
    }  
    
     // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setTxtAbility1Item(String txtAbility1Item,int index) {  
        this.txtAbility1[index] = txtAbility1Item;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getTxtAbility1Item(int index) {  
        return txtAbility1[index];  
    }  
        
     // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setTxtAbility2Item(String txtAbility2Item,int index) {  
        this.txtAbility2[index] = txtAbility2Item;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getTxtAbility2Item(int index) {  
        return txtAbility2[index];  
    }  
        
     // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setTxtAbility3Item(String txtAbility3Item,int index) {  
        this.txtAbility3[index] = txtAbility3Item;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getTxtAbility3Item(int index) {  
        return txtAbility3[index];  
    }  
    
         // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setTxtAbility4Item(String txtAbility4Item,int index) {  
        this.txtAbility4[index] = txtAbility4Item;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getTxtAbility4Item(int index) {  
        return txtAbility4[index];  
    }  
    
    
     // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setEventItem(String eventItem,int index) {  
        this.event[index] = eventItem;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getEventItem(int index) {  
        return event[index];  
    }  
    
     // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setTargetItem(String targetItem,int index) {  
        this.target[index] = targetItem;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getTargetItem(int index) {  
        return target[index];  
    }  
    
         // ESTE É UM METOTO CRIADO PARA ARMAZENAR UM ITEM DENTRO DA LISTA PASSANDO UM INDEX  
    public void setNoItem(String noItem,int index) {  
        this.no[index] = noItem;  
    }  
    // ESTE É UM METOTO CRIADO PARA ARMAZENAR RETORNAR UM ITEM DA LISTA DE ACOROD COM O INDEX  
    public String getNoItem(int index) {  
        return no[index];  
    } 
}
