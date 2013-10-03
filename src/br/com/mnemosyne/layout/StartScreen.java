/*     */ package br.com.mnemosyne.layout;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UIManager.LookAndFeelInfo;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ 
/*     */ public class StartScreen extends JFrame
/*     */ {
/*     */   private JButton botAlterarDeck;
/*     */   private JButton botConsultarDeck;
/*     */   public JButton botCriarDeck;
/*     */   private JButton jButton1;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JTextField txtCaminhoConsulta;
/*     */   private JTextField txtCaminhoModificar;
/*     */   private JTextField txtNomeDeck;
/*     */ 
/*     */   public StartScreen()
/*     */   {
/*  27 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  34 */     this.jLabel1 = new JLabel();
/*  35 */     this.jButton1 = new JButton();
/*  36 */     this.jLabel2 = new JLabel();
/*  37 */     this.jLabel3 = new JLabel();
/*  38 */     this.txtCaminhoModificar = new JTextField();
/*  39 */     this.jLabel4 = new JLabel();
/*  40 */     this.jLabel5 = new JLabel();
/*  41 */     this.txtNomeDeck = new JTextField();
/*  42 */     this.botCriarDeck = new JButton();
/*  43 */     this.jLabel6 = new JLabel();
/*  44 */     this.txtCaminhoConsulta = new JTextField();
/*  45 */     this.jButton3 = new JButton();
/*  46 */     this.botAlterarDeck = new JButton();
/*  47 */     this.botConsultarDeck = new JButton();
/*     */ 
/*  49 */     setDefaultCloseOperation(3);
/*  50 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/*  52 */     this.jLabel1.setFont(new Font("Tahoma", 0, 14));
/*  53 */     this.jLabel1.setText("Bem vindo ao Deck Builder Mnemosyne");
/*  54 */     getContentPane().add(this.jLabel1, new AbsoluteConstraints(10, 20, -1, -1));
/*     */ 
/*  56 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/br/com/mnemosyne/resources/images/search.jpg")));
/*  57 */     this.jButton1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/*  59 */         StartScreen.this.jButton1MouseClicked(evt);
/*     */       }
/*     */     });
/*  62 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  64 */         StartScreen.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  67 */     getContentPane().add(this.jButton1, new AbsoluteConstraints(490, 110, 50, 50));
/*     */ 
/*  69 */     this.jLabel2.setFont(new Font("Tahoma", 0, 14));
/*  70 */     this.jLabel2.setText("É muito fácil começar!");
/*  71 */     getContentPane().add(this.jLabel2, new AbsoluteConstraints(20, 60, -1, -1));
/*     */ 
/*  73 */     this.jLabel3.setText("Se você quer modificar seu Deck encontre-o aqui:");
/*  74 */     getContentPane().add(this.jLabel3, new AbsoluteConstraints(10, 100, -1, -1));
/*     */ 
/*  76 */     this.txtCaminhoModificar.setEditable(false);
/*  77 */     this.txtCaminhoModificar.setText("\n");
/*  78 */     this.txtCaminhoModificar.setEnabled(false);
/*  79 */     this.txtCaminhoModificar.setName("teste");
/*  80 */     getContentPane().add(this.txtCaminhoModificar, new AbsoluteConstraints(10, 120, 460, -1));
/*     */ 
/*  82 */     this.jLabel4.setText("Ou crie um novo Deck aqui:");
/*  83 */     getContentPane().add(this.jLabel4, new AbsoluteConstraints(10, 210, -1, -1));
/*     */ 
/*  85 */     this.jLabel5.setText("Título do Deck:");
/*  86 */     getContentPane().add(this.jLabel5, new AbsoluteConstraints(10, 230, -1, -1));
/*  87 */     getContentPane().add(this.txtNomeDeck, new AbsoluteConstraints(10, 250, 268, -1));
/*     */ 
/*  89 */     this.botCriarDeck.setText("Criar!");
/*  90 */     this.botCriarDeck.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/*  92 */         StartScreen.this.botCriarDeckMouseClicked(evt);
/*     */       }
/*     */     });
/*  95 */     this.botCriarDeck.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         StartScreen.this.botCriarDeckActionPerformed(evt);
/*     */       }
/*     */     });
/* 100 */     getContentPane().add(this.botCriarDeck, new AbsoluteConstraints(300, 250, -1, 20));
/*     */ 
/* 102 */     this.jLabel6.setText("Se você quiser consultar seu Deck selecione-o aqui:");
/* 103 */     getContentPane().add(this.jLabel6, new AbsoluteConstraints(10, 320, -1, -1));
/*     */ 
/* 105 */     this.txtCaminhoConsulta.setEnabled(false);
/* 106 */     getContentPane().add(this.txtCaminhoConsulta, new AbsoluteConstraints(10, 350, 460, -1));
/*     */ 
/* 108 */     this.jButton3.setIcon(new ImageIcon("C:\\Users\\Yasmin\\Desktop\\Botões\\search.jpg"));
/* 109 */     this.jButton3.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 111 */         StartScreen.this.jButton3MouseClicked(evt);
/*     */       }
/*     */     });
/* 114 */     getContentPane().add(this.jButton3, new AbsoluteConstraints(500, 340, 50, 50));
/*     */ 
/* 116 */     this.botAlterarDeck.setText("Alterar");
/* 117 */     getContentPane().add(this.botAlterarDeck, new AbsoluteConstraints(10, 160, -1, -1));
/*     */ 
/* 119 */     this.botConsultarDeck.setText("Consultar");
/* 120 */     getContentPane().add(this.botConsultarDeck, new AbsoluteConstraints(10, 380, -1, -1));
/*     */ 
/* 122 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1MouseClicked(MouseEvent evt) {
/* 126 */     String caminhoArquivo = "";
/*     */ 
/* 128 */     JFileChooser arquivo = new JFileChooser();
/* 129 */     arquivo.setDialogTitle("Selecione seu Deck");
/*     */ 
/* 131 */     arquivo.setFileFilter(new FileFilter()
/*     */     {
/*     */       public boolean accept(File f) {
/* 134 */         return (f.getName().toLowerCase().endsWith(".xml")) || (f.isDirectory());
/*     */       }
/*     */ 
/*     */       public String getDescription() {
/* 138 */         return "Arquivos de deck (.xml)";
/*     */       }
/*     */     });
/* 143 */     int retorno = arquivo.showOpenDialog(null);
/* 144 */     if (retorno == 0) {
/* 145 */       caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
/*     */     }
/*     */ 
/* 151 */     this.txtCaminhoModificar.setText(caminhoArquivo);
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void botCriarDeckMouseClicked(MouseEvent evt)
/*     */   {
/* 165 */     CreateDeck createDeckForm = new CreateDeck();
/* 166 */     createDeckForm.setVisible(true);
/* 167 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   private void botCriarDeckActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton3MouseClicked(MouseEvent evt) {
/* 175 */     String caminhoArquivo = "";
/*     */ 
/* 177 */     JFileChooser arquivo = new JFileChooser();
/* 178 */     arquivo.setDialogTitle("Selecione seu Deck");
/*     */ 
/* 180 */     arquivo.setFileFilter(new FileFilter()
/*     */     {
/*     */       public boolean accept(File f) {
/* 183 */         return (f.getName().toLowerCase().endsWith(".xml")) || (f.isDirectory());
/*     */       }
/*     */ 
/*     */       public String getDescription() {
/* 187 */         return "Arquivos de deck (.xml)";
/*     */       }
/*     */     });
/* 192 */     int retorno = arquivo.showOpenDialog(null);
/* 193 */     if (retorno == 0) {
/* 194 */       caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
/*     */     }
/*     */ 
/* 200 */     this.txtCaminhoConsulta.setText(caminhoArquivo);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 213 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
/* 214 */         if ("Nimbus".equals(info.getName())) {
/* 215 */           UIManager.setLookAndFeel(info.getClassName());
/* 216 */           break;
/*     */         }
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 220 */       Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 222 */       Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 224 */       Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (UnsupportedLookAndFeelException ex) {
/* 226 */       Logger.getLogger(StartScreen.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */ 
/* 231 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 233 */         new StartScreen().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.layout.StartScreen
 * JD-Core Version:    0.6.2
 */