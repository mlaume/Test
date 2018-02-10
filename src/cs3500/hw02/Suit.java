package cs3500.hw02;

/**
 * Represents a suit on a card. Only can be diamond, heart, spade, club.
 */
public enum Suit {
  Diamond("♦", false),
  Heart("♥", false),
  Spade("♠", true),
  Club("♣", true);

  private String suit;
  public boolean isBlack;

  /**
   * Constructs a {@Suit} object.
   *
   * @param suit either club, heart, diamond, or spades
   * @param isBlack if the card if black then it is true
   */

  Suit(String suit, boolean isBlack) {
    this.suit = suit;
    this.isBlack = isBlack;
  }

  /**
   * Returns the suit details as a string.
   *
   * @return a string of the suit
   */
  public String toSuit() {
    return this.suit;
  }

}
