package cs3500.hw02;

/**
 * Represents a card with a Suit and Value.
 */

public final class Card {
  //HW4 change to protected
  protected Suit suit;
  protected Value value;


  /**
   * Constructs a {@Card} object.
   *
   * @param suit either club, heart, diamond, or spades
   * @param value ace, 2 through 9, jack, queen, king
   */

  public Card(Value value, Suit suit) {
    this.value = value;
    this.suit = suit;

  }

  /**
   * Returns the card details as a string.
   *
   * @return a string with the card's information
   */
  public String toString() {
    return this.value.rank + this.suit.toSuit();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Card card = (Card) o;

    if (suit != card.suit) {
      return false;
    }
    return value == card.value;
  }

  @Override
  public int hashCode() {
    int result = suit != null ? suit.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  /**
   * This card is the same color as that card.
   * @param c the card that is compared to
   * @return boolean the two cards' colors are the same
   * @throws if not alternating colors ( black then red, vice versa)
   */
  //HW4 change to public
  public boolean isNotSameColor(Card c) {
    return this.suit.isBlack != c.suit.isBlack;
  }

  /**
   * This card(destination) is one less than that card(shift card)
   * @param c the card that is one more than this card.
   * @return boolean this card is one less.
   * @throws if the card you want to shift is not one more than the other card
   */
  //HW4 change to public
  public boolean isOneLess(Card c) {
    return this.value.value == c.value.value + 1;
  }

  /**
   * The passed in card can move to where this card is base on the conditions that the colors
   * are alternating and the values are one more than the other.
   * @param c the card that wants to move to this card
   * @return boolean you can move the cards following the rules
   */
  //HW4 change to protected
  public boolean canMove(Card c) {
    return this.isNotSameColor(c) && this.isOneLess(c);
  }

  /**
   * This card(destination) is one less than that card(shift card)
   * @param c the card that is one more than this card.
   * @return boolean this card is one less.
   * @throws if the card you want to shift is not one more than the other card
   */
  //HW4 change to protected
  protected boolean isOneMore(Card c) {
    return this.value.value + 1 == c.value.value;
  }

  /**
   * The passed in card can move to where this card is base on the conditions that the suits
   * are the same and the values are one more than the other.
   * @param c the card that wants to move to this card
   * @return boolean you can move the cards following the rules
   */
  //HW4 change to protected
  protected boolean canMoveFoundation(Card c) {
    return this.suit.toSuit().equals(c.suit.toSuit()) && this.isOneMore(c);
  }
}
