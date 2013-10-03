/*    */ package br.com.mnemosyne.adapters;
/*    */ 
/*    */ import br.com.mnemosyne.events.Event;
/*    */ import java.lang.reflect.Method;
/*    */ import javax.xml.bind.annotation.adapters.XmlAdapter;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class EventAdapter extends XmlAdapter<Object, Event>
/*    */ {
/*    */   public Object marshal(Event arg0)
/*    */     throws Exception
/*    */   {
/* 13 */     return null;
/*    */   }
/*    */ 
/*    */   public Event unmarshal(Object arg0) throws Exception
/*    */   {
/* 18 */     Element curr = (Element)arg0;
/* 19 */     String eventName = curr.getAttribute("type");
/* 20 */     eventName = "br.com.mnemosyne.events." + eventName.replaceFirst(String.valueOf(eventName.charAt(0)), String.valueOf(eventName.toUpperCase().charAt(0))) + "Event";
/* 21 */     Event e = (Event)Thread.currentThread().getContextClassLoader().loadClass(eventName).newInstance();
/* 22 */     if (curr.getElementsByTagName("oper").getLength() > 0) {
/* 23 */       e.getClass().getMethod("setOperation", new Class[] { String.class }).invoke(e, new Object[] { curr.getElementsByTagName("oper").item(0).getTextContent() });
/*    */     }
/*    */ 
/* 27 */     if (curr.getElementsByTagName("no").getLength() > 0) {
/* 28 */       e.getClass().getMethod("setParameter", new Class[] { Integer.class }).invoke(e, new Object[] { Integer.valueOf(Integer.parseInt(curr.getElementsByTagName("no").item(0).getTextContent())) });
/*    */     }
/*    */ 
/* 32 */     if (curr.getElementsByTagName("type").getLength() > 0) {
/* 33 */       e.getClass().getMethod("setResourceType", new Class[] { String.class }).invoke(e, new Object[] { curr.getElementsByTagName("type").item(0).getTextContent() });
/*    */     }
/*    */ 
/* 36 */     return e;
/*    */   }
/*    */ }

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.adapters.EventAdapter
 * JD-Core Version:    0.6.2
 */