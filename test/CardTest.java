import static junit.framework.TestCase.assertEquals;

import cs3500.hw02.Card;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import org.junit.Test;

/**
 * To test the card methods.
 */
public class CardTest {

  Card c1 = new Card( Value.Two, Suit.Club);
  Card c2 = new Card( Value.Two, Suit.Club);
  Card d0 = new Card(Value.Three, Suit.Diamond);
  Card d1 = new Card(Value.Three, Suit.Club);

  //test all 52 cards, no repeats
  @Test
  public void stringCard() {
    assertEquals("2♣", this.c1.toString());
  }

  //test all 52 cards, no repeats
  @Test
  public void canMove() {
    assertEquals(true, this.c2.canMove(this.d0));
  }

  //Test IllegalArgumentException
  @Test(expected = IllegalArgumentException.class) public void sameColor() {
    this.c2.canMove(this.d1);
  }

  //Test IllegalArgumentException
  @Test(expected = IllegalArgumentException.class) public void sameValue() {
    this.c2.canMove(this.c2);
  }


}
