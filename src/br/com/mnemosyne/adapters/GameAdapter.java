/*     */ package br.com.mnemosyne.adapters;
/*     */ 
/*     */ import br.com.mnemosyne.beans.Effect;
/*     */ import br.com.mnemosyne.beans.Game;
/*     */ import br.com.mnemosyne.beans.Player;
/*     */ import br.com.mnemosyne.events.Event;
/*     */ import br.com.mnemosyne.interfaces.AbstractPhase;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.LinkedList;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import javax.xml.bind.annotation.adapters.XmlAdapter;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class GameAdapter extends XmlAdapter<Object, Game>
/*     */ {
/*     */   public Object marshal(Game arg0)
/*     */     throws Exception
/*     */   {
/*  20 */     return null;
/*     */   }
/*     */ 
/*     */   public Game unmarshal(Object arg0)
/*     */     throws Exception
/*     */   {
/*  26 */     Element curr = (Element)arg0;
/*  27 */     Game g = Game.getInstance();
/*  28 */     g.setName(curr.getAttribute("name"));
/*  29 */     PlayerAdapter pa = new PlayerAdapter();
/*  30 */     g.setPlayerOne(pa.unmarshal((Element)curr.getElementsByTagName("player").item(0)));
/*  31 */     g.setPlayerTwo(pa.unmarshal((Element)curr.getElementsByTagName("player").item(0)));
/*     */ 
/*  33 */     g.getPlayerOne().setName(curr.getElementsByTagName("name").item(0).getAttributes().getNamedItem("player1").getNodeValue());
/*  34 */     g.getPlayerTwo().setName(curr.getElementsByTagName("name").item(0).getAttributes().getNamedItem("player2").getNodeValue());
/*     */ 
/*  36 */     LinkedList phases = new LinkedList();
/*     */ 
/*  38 */     for (int i = 0; i < curr.getElementsByTagName("initial").getLength(); i++) {
/*  39 */       Element phaseElement = (Element)curr.getElementsByTagName("initial").item(i);
/*  40 */       phases.add(getPhaseForElement(phaseElement));
/*     */     }
/*     */ 
/*  43 */     for (int i = 0; i < curr.getElementsByTagName("main").getLength(); i++) {
/*  44 */       Element phaseElement = (Element)curr.getElementsByTagName("main").item(i);
/*  45 */       phases.add(getPhaseForElement(phaseElement));
/*     */     }
/*     */ 
/*  48 */     for (int i = 0; i < curr.getElementsByTagName("battle").getLength(); i++) {
/*  49 */       Element phaseElement = (Element)curr.getElementsByTagName("battle").item(i);
/*  50 */       phases.add(getPhaseForElement(phaseElement));
/*     */     }
/*     */ 
/*  53 */     for (int i = 0; i < curr.getElementsByTagName("final").getLength(); i++) {
/*  54 */       Element phaseElement = (Element)curr.getElementsByTagName("final").item(i);
/*  55 */       phases.add(getPhaseForElement(phaseElement));
/*     */     }
/*     */ 
/*  58 */     g.setPhases(phases);
/*     */ 
/*  61 */     g.setResourceLimit(Integer.valueOf(Integer.parseInt(((Element)curr.getElementsByTagName("resource").item(0)).getAttribute("limitPerTurn"))));
/*     */ 
/*  63 */     g.defineBlocker(Boolean.valueOf(Boolean.parseBoolean(((Element)curr.getElementsByTagName("canDefineBlocker").item(0)).getTextContent())));
/*     */ 
/*  65 */     return g;
/*     */   }
/*     */ 
/*     */   public AbstractPhase getPhaseForElement(Element element) {
/*     */     try {
/*  70 */       String className = element.getNodeName().replaceFirst(String.valueOf(element.getNodeName().charAt(0)), String.valueOf(element.getNodeName().toUpperCase().charAt(0)));
/*  71 */       AbstractPhase phase = (AbstractPhase)Class.forName("br.com.mnemosyne.beans." + className + "Phase").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
/*     */ 
/*  73 */       phase.setName(element.getAttribute("name"));
/*  74 */       LinkedList onStartEffects = new LinkedList();
/*  75 */       for (int j = 0; j < ((Element)element.getElementsByTagName("onStart").item(0)).getElementsByTagName("effect").getLength(); j++) {
/*  76 */         Element effectElement = (Element)((Element)element.getElementsByTagName("onStart").item(0)).getElementsByTagName("effect").item(j);
/*  77 */         Effect effect = (Effect)JAXBContext.newInstance(new Class[] { Effect.class }).createUnmarshaller().unmarshal(effectElement);
/*  78 */         onStartEffects.add(effect);
/*     */       }
/*  80 */       phase.setOnStartEffects(onStartEffects);
/*  81 */       LinkedList onEndEffects = new LinkedList();
/*     */ 
/*  84 */       for (int j = 0; j < ((Element)element.getElementsByTagName("onEnd").item(0)).getElementsByTagName("effect").getLength(); j++) {
/*  85 */         Element effectElement = (Element)((Element)element.getElementsByTagName("onEnd").item(0)).getElementsByTagName("effect").item(j);
/*  86 */         Effect effect = (Effect)JAXBContext.newInstance(new Class[] { Effect.class }).createUnmarshaller().unmarshal(effectElement);
/*  87 */         onEndEffects.add(effect);
/*     */       }
/*  89 */       phase.setOnEndEffects(onEndEffects);
/*  90 */       String[] obligatedEventsName = element.getElementsByTagName("obligatedEvents").item(0).getTextContent().split(",");
/*  91 */       LinkedList obligatedEvents = new LinkedList();
/*  92 */       for (String event : obligatedEventsName) {
/*  93 */         event = event.trim();
/*  94 */         if (event != "") {
/*  95 */           obligatedEvents.add((Event)Class.forName("br.com.mnemosyne.events." + event + "Event").newInstance());
/*     */         }
/*     */       }
/*  98 */       phase.setObligatedEvents(obligatedEvents);
/*  99 */       String[] permitedEventsName = element.getElementsByTagName("permitedEvents").item(0).getTextContent().split(",");
/* 100 */       LinkedList permitedEvents = new LinkedList();
/* 101 */       for (String event : permitedEventsName) {
/* 102 */         event = event.trim();
/* 103 */         if (event != "") {
/* 104 */           permitedEvents.add((Event)Class.forName("br.com.mnemosyne.events." + event + "Event").newInstance());
/*     */         }
/*     */       }
/* 107 */       phase.setPermitedEvents(permitedEvents);
/* 108 */       return phase;
/*     */     } catch (Exception e) {
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.GameAdapter
 * JD-Core Version:    0.6.2
 */