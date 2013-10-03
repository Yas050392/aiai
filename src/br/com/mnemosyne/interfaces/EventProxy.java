package br.com.mnemosyne.interfaces;

import br.com.mnemosyne.events.Event;
import br.com.mnemosyne.events.Filter;
import br.com.mnemosyne.events.Subscriber;

public abstract interface EventProxy
{
  public abstract void subscribe(Class<? extends Event> paramClass, Filter paramFilter, Subscriber paramSubscriber);

  public abstract void unsubscribe(Class<? extends Event> paramClass, Filter paramFilter, Subscriber paramSubscriber);

  public abstract void publish(Event paramEvent);
}

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.interfaces.EventProxy
 * JD-Core Version:    0.6.2
 */