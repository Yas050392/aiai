package br.com.mnemosyne.interfaces;

import br.com.mnemosyne.beans.Player;

public abstract interface Zonneable
{
  public abstract AbstractCard getCard(EnLocalPositions paramEnLocalPositions);

  public abstract AbstractCard getCard(AbstractCard paramAbstractCard);

  public abstract AbstractCard getCard(Integer paramInteger);

  public abstract AbstractCard searchCard(String paramString);

  public abstract AbstractCard searchById(Integer paramInteger);

  public abstract String getZoneName();

  public abstract Player getOwner();

  public abstract Integer getSize();

  public abstract void setOwner(Player paramPlayer);

  public abstract void putCard(EnLocalPositions paramEnLocalPositions, AbstractCard paramAbstractCard);

  public abstract Boolean canCardsReturnToGame();

  public abstract Zonneable shuffle();
}

/* Location:           C:\Users\Yasmin\Desktop\Deck Builder 26-09\Mnemosyne\build\classes\
 * Qualified Name:     br.com.mnemosyne.interfaces.Zonneable
 * JD-Core Version:    0.6.2
 */