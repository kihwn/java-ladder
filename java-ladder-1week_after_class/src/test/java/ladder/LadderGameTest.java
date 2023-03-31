package ladder;

import ladder.creator.LadderCreator;
import ladder.creator.LadderDirectlyCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.createNaturalNumber;
import static ladder.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class LadderGameTest {



    @Test
    @DisplayName("만들어진 사다리 이상의 사람 예외 처리")
    void nthOfPersonValidate() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        NaturalNumber row = createNaturalNumber(1);
        LadderCreator ladderCreator = new LadderDirectlyCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);


        //given
        Position position = createPosition(3);

        //then
        assertThrows(IllegalArgumentException.class,()-> ladderGame.run(position));
    }

    @Test
    @DisplayName("1 -1 0 0 / 0 1 -1 0 / 1 -1 0 0")
    void threeRowFourColWithLine() {

        NaturalNumber numberOfPerson = createNaturalNumber(4);
        NaturalNumber row = createNaturalNumber(3);
        LadderCreator ladderCreator = new LadderDirectlyCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(createPosition(0), createPosition(0));
        ladderCreator.drawLine(createPosition(1),createPosition(1));
        ladderCreator.drawLine(createPosition(2),createPosition(0));


        Position nthOfPerson = createPosition(0);
        assertEquals(2, ladderGame.run(nthOfPerson));


        nthOfPerson = createPosition(1);
        assertEquals(1, ladderGame.run(nthOfPerson));


        nthOfPerson = createPosition(2);
        assertEquals(0, ladderGame.run(nthOfPerson));



    }
    @Test
    @DisplayName("랜덤 테스트")
    void randomTest(){
        NaturalNumber numberOfPerson = createNaturalNumber(5);
        NaturalNumber row = createNaturalNumber(4);
        LadderCreator ladderCreator1 = new LadderRandomCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(ladderCreator1);
        ladderCreator1.drawLine();
        Position nthOfPerson = createPosition(3);
        ladderGame.run(nthOfPerson);

    }

}