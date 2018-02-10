import static junit.framework.TestCase.assertEquals;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw03.FreecellController;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by Megan on 5/25/2017.
 */
public class FreecellControllerTest {

  Card d0 = new Card(Value.Ace, Suit.Diamond);
  Card d1 = new Card(Value.Two, Suit.Diamond);
  Card d2 = new Card(Value.Three, Suit.Diamond);
  Card d3 = new Card(Value.Four, Suit.Diamond);
  Card d4 = new Card(Value.Five, Suit.Diamond);
  Card d5 = new Card(Value.Six, Suit.Diamond);
  Card d6 = new Card(Value.Seven, Suit.Diamond);
  Card d7 = new Card(Value.Eight, Suit.Diamond);
  Card d8 = new Card(Value.Nine, Suit.Diamond);
  Card d9 = new Card(Value.Ten, Suit.Diamond);
  Card d10 = new Card(Value.Jack, Suit.Diamond);
  Card d11 = new Card(Value.Queen, Suit.Diamond);
  Card d12 = new Card(Value.King, Suit.Diamond);
  Card h0 = new Card(Value.Ace, Suit.Heart);
  Card h1 = new Card(Value.Two, Suit.Heart);
  Card h2 = new Card(Value.Three, Suit.Heart);
  Card h3 = new Card(Value.Four, Suit.Heart);
  Card h4 = new Card(Value.Five, Suit.Heart);
  Card h5 = new Card(Value.Six, Suit.Heart);
  Card h6 = new Card(Value.Seven, Suit.Heart);
  Card h7 = new Card(Value.Eight, Suit.Heart);
  Card h8 = new Card(Value.Nine, Suit.Heart);
  Card h9 = new Card(Value.Ten, Suit.Heart);
  Card h10 = new Card(Value.Jack, Suit.Heart);
  Card h11 = new Card(Value.Queen, Suit.Heart);
  Card h12 = new Card(Value.King, Suit.Heart);
  Card s0 = new Card(Value.Ace, Suit.Spade);
  Card s1 = new Card(Value.Two, Suit.Spade);
  Card s2 = new Card(Value.Three, Suit.Spade);
  Card s3 = new Card(Value.Four, Suit.Spade);
  Card s4 = new Card(Value.Five, Suit.Spade);
  Card s5 = new Card(Value.Six, Suit.Spade);
  Card s6 = new Card(Value.Seven, Suit.Spade);
  Card s7 = new Card(Value.Eight, Suit.Spade);
  Card s8 = new Card(Value.Nine, Suit.Spade);
  Card s9 = new Card(Value.Ten, Suit.Spade);
  Card s10 = new Card(Value.Jack, Suit.Spade);
  Card s11 = new Card(Value.Queen, Suit.Spade);
  Card s12 = new Card(Value.King, Suit.Spade);
  Card c0 = new Card(Value.Ace, Suit.Club);
  Card c1 = new Card(Value.Two, Suit.Club);
  Card c2 = new Card(Value.Three, Suit.Club);
  Card c3 = new Card(Value.Four, Suit.Club);
  Card c4 = new Card(Value.Five, Suit.Club);
  Card c5 = new Card(Value.Six, Suit.Club);
  Card c6 = new Card(Value.Seven, Suit.Club);
  Card c7 = new Card(Value.Eight, Suit.Club);
  Card c8 = new Card(Value.Nine, Suit.Club);
  Card c9 = new Card(Value.Ten, Suit.Club);
  Card c10 = new Card(Value.Jack, Suit.Club);
  Card c11 = new Card(Value.Queen, Suit.Club);
  Card c12 = new Card(Value.King, Suit.Club);

  // an array of cards
  List<Card> cardList = new ArrayList<>(
      Arrays.asList(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12,
          h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12,
          s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12,
          c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));

  // Duplicates and not 52 cards in the deck
  List<Card> badDeck = new ArrayList<>(
      Arrays.asList(d0, d0, d0, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12,
          h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12,
          s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12,
          c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11));

  StringBuffer out;
  FreecellModel f1;
  FreecellController c;
  List empty = new ArrayList();

  void initStart() {
    Reader stringReader;
    stringReader = new StringReader("C2 10 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 4, 2, false);
  }

  void initQuit() {
    Reader stringReader;
    stringReader = new StringReader("q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initMoveToOpen() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initCascadeToFoundation() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 F1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initCascadeToCascade() {
    Reader stringReader;
    stringReader = new StringReader("C5 0 C32 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initOpenToCascade() {
    Reader stringReader;
    stringReader = new StringReader("C1 0 O1 O1 0 F1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initTwoOpen() {
    Reader stringReader;
    stringReader = new StringReader("C1 0 O1 C2 0 O1");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initBadPlayGame() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(null, f1, 52, 4, false);
  }

  void initEmptyModel() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel(empty, empty, empty, empty, true);
    c.playGame(null, f1, 52, 4, false);
  }

  void initBadDeck() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(badDeck, f1, 52, 4, false);
  }

  void initEmptyDeck() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(empty, f1, 52, 4, false);
  }

  void initEmptyReadable() {
    Reader stringReader;
    out = new StringBuffer();
    c = new FreecellController(null, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initBadSource() {
    Reader stringReader;
    stringReader = new StringReader("Z1 1 O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initBadCardIndex() {
    Reader stringReader;
    stringReader = new StringReader("C1 Yolo O1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initBadDestination() {
    Reader stringReader;
    stringReader = new StringReader("C1 1 P9 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initBadEverything() {
    Reader stringReader;
    stringReader = new StringReader("Z1 U P1 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initEntered() {
    Reader stringReader;
    stringReader = new StringReader("C1" + '\n' + "2" + '\n' + "O1" + '\n' + "q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 4, false);
  }

  void initGameOver() {
    Reader stringReader;
    stringReader = new StringReader("C14 1 F2 C15 1 F2 C16 1 F2 C17 1 F2 C18 1 F2 C19 1 F2 C20 1 F2 C21 1 F2 C22 1 F2 C23 1 F2 C24 1 F2 C25 1 F2 C26 1 F2 q");
    out = new StringBuffer();
    c = new FreecellController(stringReader, out);
    f1 = new FreecellModel();
    c.playGame(cardList, f1, 52, 2, false);
  }

  //Test bad inputs to play game
  @Test(expected = IllegalArgumentException.class)
  public void badGamePlay() {
    this.initBadPlayGame();
  }

  //Test move cascade to open
  @Test
  public void notGameOver() {
    this.initMoveToOpen();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: \n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "\n"
        + "Game quit prematurely.", out.toString());
  }

  //Test quit prematurely
  @Test
  public void quitGame() {
    this.initQuit();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "\n"
        + "Game quit prematurely.", out.toString());
  }

  //test a bad deck
  @Test(expected = IllegalArgumentException.class) public void throwBadDeck() {
    this.initBadDeck();
  }


  //Test empty deck
  @Test (expected = IllegalArgumentException.class)
  public void emptyDeck() {
    this.initEmptyDeck();
  }

  //empty readable
  @Test (expected = IllegalStateException.class)
  public void emptyReadable() {
    this.initEmptyReadable();
  }

  //Test the piles are created correctly
  @Test
  public void startPrint() {
    this.initStart();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "C1: A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 2♣, 6♣, 10♣\n"
        + "C2: 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠, 3♣, 7♣, J♣\n"
        + "C3: 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠, 4♣, 8♣, Q♣\n"
        + "C4: 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠, A♣, 5♣, 9♣, K♣\n"
        + "Enter your move\n"
        + "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 2♣, 6♣, 10♣\n"
        + "O2:\n"
        + "C1: A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 2♣, 6♣, 10♣\n"
        + "C2: 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠, 3♣, 7♣\n"
        + "C3: 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠, 4♣, 8♣, Q♣\n"
        + "C4: 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠, A♣, 5♣, 9♣, K♣\n"
        + "Enter your move\n"
        + "\n"
        + "Game quit prematurely.", out.toString());
  }

  //Test invalid source
  @Test
  public void badSource() {
    this.initBadSource();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Wrong pile. Enter pile again\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void badCardIndex() {
    this.initBadCardIndex();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Wrong cardIndex. Enter cardIndex again\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void badDestination() {
    this.initBadDestination();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Wrong pile. Enter pile again\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void badEverything() {
    this.initBadEverything();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Wrong pile. Enter pile again\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void cascadeToFoundationTwo() {
    this.initCascadeToFoundation();
    assertEquals("F1:A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: \n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Wrong pile. Enter pile again\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void cascadeToFoundation() {
    this.initCascadeToCascade();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: \n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠6♦\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void openToCascade() {
    this.initOpenToCascade();
    assertEquals("F1:A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: \n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: \n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠6♦\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void TwoCardsInOpen() {
    this.initTwoOpen();
    assertEquals("F1:A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: \n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: \n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠6♦\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣\n"
        + "Enter your move\n"
        + "Invalid move. Try again. "
        + "Already has a card. Place somewhere else"
        + "Game quit prematurely.", this.out.toString());
  }

  @Test
  public void gameOver() {
    this.initGameOver();
    System.out.println(out.toString());
  }
}
