package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.NaturalNumber.*;
import static ladder.Position.*;
import static ladder.Row.createRow;
import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    @DisplayName("사다리 : 0")
    void OneColWithoutLine() {

        //when
        NaturalNumber numberOfPerson = createNaturalNumber(1);
        Row row = createRow(numberOfPerson);

        //given
        int nthOfPerson = 0;
        Position position = createPosition(nthOfPerson);
        row.nextPosition(position);

        //then
        assertEquals(0, position.getPosition());
    }

    @Test
    @DisplayName("사다리 : 11")
    void twoColWithLine() {

        //when
        NaturalNumber numberOfPerson = createNaturalNumber(2);

        Row row = createRow(numberOfPerson);
        row.drawLine(createPosition(0));
        //given
        int nthOfPerson = 0;
        Position position = createPosition(nthOfPerson);
        row.nextPosition(position);

        //then
        assertEquals(1, position.getPosition());

        //given
        nthOfPerson = 1;
        position = createPosition(nthOfPerson);
        row.nextPosition(position);
        //then
        assertEquals(0, position.getPosition());
    }

    @Test
    @DisplayName("사다리 : 110")
    void oneRowThreeColWithLine() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);

        row.drawLine(createPosition(0));


        //given
        int nthOfPerson = 0;
        Position position = createPosition(nthOfPerson);
        row.nextPosition(position);

        //then
        assertEquals(1, position.getPosition());

        //given
        nthOfPerson = 1;
        position = createPosition(nthOfPerson);
        row.nextPosition(position);

        //then
        assertEquals(0, position.getPosition());

        //given
        nthOfPerson = 2;
        position = createPosition(nthOfPerson);
        row.nextPosition(position);

        //then
        assertEquals(2, position.getPosition());
    }

    @Test
    @DisplayName("사다리 사람이 0명인 경우 예외처리")
    void validateNumberOfPerson() {
        assertThrows(IllegalArgumentException.class, () -> createNaturalNumber(0));
    }

    @Test
    @DisplayName("만들어진 사다리 이상의 사람 예외 처리")
    void nthOfPersonValidateOutOfRangeMAX() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);

        //givens
        Position position = createPosition(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    @DisplayName("1번째 이하의 사람 예외 처리")
    void nthOfPersonValidateOutOfRangeMIN() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> createPosition(position));
    }


    @Test
    void ValidateDrawLinePositionOverRange() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);

        //given

        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(createPosition(position)));

    }

    @Test
    void ValidateDrawLinePositionUnderRange() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);

        //given

        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(createPosition(position)));
    }

    @Test
    void ValidateDrawLinePositionAlreadyHasLineLeft() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);
        row.drawLine(createPosition(0));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(createPosition(1)));
    }

    @Test
    void ValidateDrawLinePositionAlreadyHasLineRight() {
        //when
        NaturalNumber numberOfPerson = createNaturalNumber(3);
        Row row = createRow(numberOfPerson);
        row.drawLine(createPosition(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(createPosition(0)));
    }
}