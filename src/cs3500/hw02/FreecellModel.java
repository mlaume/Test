package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Represents a FreecellModel with a deck of cards, a list of open piles, a list of cascade piles,
 * a list of foundation piles, and if the game is started or not.
 */

public class FreecellModel implements FreecellOperations {
  //HW4 change to protected
  protected List<Card> deck;
  protected List<List<Card>> open;
  protected List<List<Card>> cascade;
  protected List<List<Card>> foundation;
  protected boolean isGameStarted;

  /**Constructs a {@FreecellModel} object.
   *
   */
  public FreecellModel() {
    this.deck = this.getDeck();
    this.open = this.makePile(0);
    this.cascade = this.makePile(0);
    this.foundation = this.makePile(4);
    this.isGameStarted = false;
  }

  /**
   * Constructs a FreecellModel with the deck, open, cascade, and foundation.
   *
   * @param deck a deck of 52, no duplicate, valid card deck
   * @param open a list of open piles
   * @param cascade a list of cascade piles
   * @param foundation a list of foundation piles
   * @param isGameStarted checks if the game is started or not
   */
  //HW4 change to protected
  public FreecellModel(List<Card> deck,
      List<List<Card>> open,
      List<List<Card>> cascade,
      List<List<Card>> foundation,
      boolean isGameStarted) {
    this.deck = deck;
    this.open = open;
    this.cascade = cascade;
    this.foundation = foundation;
    this.isGameStarted = isGameStarted;
  }


  @Override
  public List<Card> getDeck() {
    List current = new ArrayList();
    for (Suit s : Suit.values()) {
      for (Value v : Value.values()) {
        Card newCard = new Card(v, s);
        current.add(newCard);
      }
    }
    return current;
  }

  /**
   * Creates the list of piles from the given number of wanted piles.
   *
   * @param numPiles the number of wanted open piles
   * @return the list of piles
   */
  //HW4 change to protected
  protected List<List<Card>> makePile(int numPiles) {
    List list = new ArrayList();
    if (numPiles == 0) {
      return list;
    } else {
      for (int i = 0; i < numPiles; i++) {
        list.add(new ArrayList<Card>());
      }
      return list;
    }
  }

  /**
   * Checks if the deck is the valid deck of cards with no duplicates, 52 cards, 13 of each suit.
   * 4 of each value.
   *
   * @return a boolean that it is a valid card deck
   * @throw if the card list is not 52 in size or is null
   */
  //HW4 change to protected
  protected boolean isValid() {
    ArrayList checkDeck = new ArrayList();
    boolean b = true;
    if (this.deck == null) {
      throw new IllegalArgumentException("deck can't be null");
    } else {
      if (this.deck.size() == 52) {
        for (int i = 0; i < this.deck.size(); i++) {
          if (!checkDeck.contains(this.deck.get(i))) {
            checkDeck.add(this.deck.get(i));
          }
          else {
            b = false;
          }
        }
        return b;
      } else {
        return false;
      }
    }
  }

  /**
   * Deals the deck of cards to each cascade piles.
   *
   * @param deck the deck of cards
   * @param numCascadePiles the number of wanted cascade piles
   * @return the list of cascade piles with cards delt to them
   */
  //HW4 change to protected
  protected List<List<Card>> dealCards(List<Card> deck, int numCascadePiles) {
    int index = 0;
    for (Card c : deck) {
      this.cascade.get(index).add(c);
      index = (index + 1) % numCascadePiles;
    }
    return this.cascade;
  }

  @Override
  public void startGame(List deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {
    this.deck = deck;
    if (this.deck == null) {
      throw new IllegalArgumentException("no null decks please");
    } else if (!this.isValid()) {
      throw new IllegalArgumentException("passed in invalid deck");
    } else if (numCascadePiles < 4 ) {
      throw new IllegalArgumentException("number of cascade piles must be atleast 4");
    }  else if (numOpenPiles < 1) {
      throw new IllegalArgumentException("number of open piles must be atleast 1");
    } else {
      this.isGameStarted = true;
      this.cascade = this.makePile(numCascadePiles);
      this.open = this.makePile(numOpenPiles);
      if (shuffle) {
        Collections.shuffle(this.deck);
        this.dealCards(this.deck, numCascadePiles);
      } else {
        this.dealCards(this.deck, numCascadePiles);
      }
    }
  }

  /**
   * Move card from cascade to cascade.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void cascadeToCascade(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.cascade.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.cascade.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    } else {
      List<Card> destPile = this.cascade.get(destPileNumber);
      List<Card> sourcePile = this.cascade.get(pileNumber);
      Card lastCard = destPile.get(destPile.size() - 1);
      if (lastCard.canMove(moveThis)) {
        destPile.add(moveThis);
        sourcePile.remove(sourcePile.size() - 1);
      } else {
        throw new IllegalArgumentException("can not move here ");
      }
    }
  }

  /**
   * Move card from cascade to open.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void cascadeToOpen(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.cascade.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.open.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    }
    if (this.open.get(destPileNumber).size() == 1) {
      throw new IllegalArgumentException("Already has a card. Place somewhere else");
    } else {
      List<Card> destPile = this.open.get(destPileNumber);
      List<Card> sourcePile = this.cascade.get(pileNumber);
      destPile.add(moveThis);
      sourcePile.remove(sourcePile.size() - 1);
    }
  }

  /**
   * Move card from cascade to foundation.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void cascadeToFoundation(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    List<Card> sourcePile = this.cascade.get(pileNumber);
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.cascade.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.foundation.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    } else {
      List<Card> destPile = this.foundation.get(destPileNumber);
      if (destPile.size() == 0 && moveThis.value.value != 1) {
        throw new IllegalArgumentException("the first card must be ace");
      }
      else if (destPile.size() == 0 && moveThis.value.value == 1) {
        destPile.add(moveThis);
        sourcePile.remove(sourcePile.size() - 1);
      }
      else {
        Card lastCard = destPile.get(destPile.size() - 1);
        if (lastCard.canMoveFoundation(moveThis)) {
          destPile.add(moveThis);
          sourcePile.remove(sourcePile.size() - 1);
        }
        else {
          throw new IllegalArgumentException("can not move here omg");
        }
      }
    }
  }

  /**
   * Move card from open to cascade.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void openToCascade(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.open.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.cascade.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    } else {
      List<Card> destPile = this.cascade.get(destPileNumber);
      Card lastCard = destPile.get(destPile.size() - 1);
      List<Card> sourcePile = this.open.get(pileNumber);
      if (lastCard.canMove(moveThis)) {
        destPile.add(moveThis);
        sourcePile.remove(sourcePile.size() - 1);
      } else {
        throw new IllegalArgumentException("can not move here ");
      }
    }
  }

  /**
   * Move card from open to open.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void openToOpen(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.open.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.open.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    }
    if (this.open.get(destPileNumber).size() == 1) {
      throw new IllegalArgumentException("Already has a card. Place somewhere else");
    } else {
      List<Card> destPile = this.open.get(destPileNumber);
      List<Card> sourcePile = this.open.get(pileNumber);
      destPile.add(moveThis);
      sourcePile.remove(sourcePile.size() - 1);
    }
  }

  /**
   * Move card from open to foundation.
   *
   * @param source the type of pile the source card is coming from
   * @param pileNumber the pile number of the source type
   * @param cardIndex the index of the pile number of the source type
   * @param destination the destination pile type
   * @param destPileNumber the number pile of the destination pile type
   * @param moveThis the card of that is being moved
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected void openToFoundation(PileType source, int pileNumber, int cardIndex,
      PileType destination, int destPileNumber, Card moveThis) {
    List<Card> sourcePile = this.open.get(pileNumber);
    if (pileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative source pile number");
    }
    if (pileNumber > this.open.size()) {
      throw new IllegalArgumentException("source pile number doesn't exist");
    }
    if (destPileNumber < 0) {
      throw new IllegalArgumentException("Cannot have a negative destination pile number");
    }
    if (destPileNumber > this.foundation.size()) {
      throw new IllegalArgumentException("destination pile number doesn't exist");
    }
    else {
      List<Card> destPile = this.foundation.get(destPileNumber);
      if (destPile.size() == 0 && moveThis.value.value != 1) {
        throw new IllegalArgumentException("the first card must be ace");
      }
      else if (destPile.size() == 0 && moveThis.value.value == 1) {
        destPile.add(moveThis);
        sourcePile.remove(sourcePile.size() - 1);
      }
      else {
        Card lastCard = destPile.get(destPile.size() - 1);
        if (lastCard.canMoveFoundation(moveThis)) {
          destPile.add(moveThis);
          sourcePile.remove(sourcePile.size() - 1);
        }
        else {
          throw new IllegalArgumentException("can not move here omg");
        }
      }
    }
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) {
    if (!this.isGameStarted) {
      throw new IllegalArgumentException("game did not start ");
    }
    if (this.deck == null) {
      throw new IllegalArgumentException("no null decks please");
    }
    if (!this.isValid()) {
      throw new IllegalArgumentException("passed in invalid deck");
    }
    if (PileType.FOUNDATION.equals(source)) {
      throw new IllegalArgumentException("Can not move from foundation pile");
    }
    else {
      if (PileType.CASCADE.equals(source) && PileType.CASCADE.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        this.cascadeToCascade(source, pileNumber, cardIndex,
            destination, destPileNumber, moveThis);
      } else if (PileType.CASCADE.equals(source) && PileType.FOUNDATION.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        this.cascadeToFoundation(source, pileNumber, cardIndex,
            destination, destPileNumber, moveThis);
      } else if (PileType.CASCADE.equals(source) && PileType.OPEN.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        this.cascadeToOpen(source, pileNumber, cardIndex,
            destination, destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.CASCADE.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToCascade(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.OPEN.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToOpen(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.FOUNDATION.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToFoundation(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else {
        throw new IllegalArgumentException("Can not move there!!!");
      }
    }
  }

  @Override
  public boolean isGameOver() {
    if (!this.isGameStarted) {
      throw new IllegalArgumentException("game did not start");
    } else {
      boolean b = true;
      for (int i = 0; i < this.foundation.size() - 1; i++) {
        if (this.foundation.get(i).size() != 13) {
          b = false;
        }
      }
      return b;
    }
  }

  /**
   * converts list of cards to string.
   *
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected String toString(List<Card> pileList) {

    String current = "";
    for (int i = 0; i < pileList.size(); i++) {
      if ( i == pileList.size() - 1) {
        current = current + pileList.get(i);
      }
      else {
        current = current + pileList.get(i) + ", ";
      }
    }
    return current;
  }

  /**
   * converts list of cards to string.
   *
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected String foundationToString() {
    String current = "";
    for (int i = 0; i < this.foundation.size(); i++) {
      if (this.foundation.get(i).size() == 0) {
        current = current + "F" + (i + 1) + ":" + this.toString(this.foundation.get(i)) + '\n';
      }
      else {
        current = current + "F" + (i + 1) + ": " + this.toString(this.foundation.get(i)) + '\n';
      }
    }
    return current;
  }

  /**
   * converts list of cards to string.
   *
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected String openToString() {
    String current = "";
    for (int i = 0; i < this.open.size(); i++) {
      if (this.open.get(i).size() != 0) {
        current = current + "O" + (i + 1) + ": " + this.toString(this.open.get(i)) + '\n';
      }
      else {
        current = current + "O" + (i + 1) + ":" + this.toString(this.open.get(i)) + '\n';
      }
    }
    return current;
  }

  /**
   * converts list of cards to string.
   *
   * @throws if the move is invalid
   */
  //HW4 change to protected
  protected String cascadeToString() {
    String current = "";
    for (int i = 0; i < this.cascade.size(); i++) {
      if (this.cascade.size() - 1 == i) {
        current = current + "C" + (i + 1) + ": " + this.toString(this.cascade.get(i));
      }
      else if (this.cascade.get(i).size() == 0) {
        current = current + "C" + (i + 1) + ":" + this.toString(this.cascade.get(i))  + '\n';
      }
      else {
        current = current + "C" + (i + 1) + ": " + this.toString(this.cascade.get(i)) + '\n';
      }
    }
    return current;
  }

  @Override
  public String getGameState() {
    if (this.isGameStarted) {
      return this.foundationToString() + this.openToString() + this.cascadeToString();
    } else {
      return "";
    }
  }
}
