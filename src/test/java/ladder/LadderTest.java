
package ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LadderTest {
    // 깃허브 올라가라



    @Test
    @DisplayName("4명의 사다리타기")
    public void forPeople() {
        MakeLadder ladder = new MakeLadder(3, 4);

        ladder.DrawLine(1,1);
        ladder.DrawLine(2,2);
        assertEquals(3, ladder.Play(1));

    }

    @Test
    @DisplayName("0보다적은 사람")
    public void zeroLowPeople() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MakeLadder(3, -1));
    }

    @Test
    @DisplayName("0보다 적은 col ")
    public void zeroLowCol() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MakeLadder(-2, 4));
    }

}
