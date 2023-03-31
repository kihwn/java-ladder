package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.Random;

import static ladder.Row.createRow;

public class LadderDirectlyCreator implements LadderCreator {
    private final Row[] rows;



    public LadderDirectlyCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new Row[row.getNumber()];
        for (int i = 0; i < row.getNumber(); i++) {

            rows[i] = createRow(numberOfPerson);
        }
    }


    //Generator : Cmd + N

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getPosition()].drawLine(col);
    }

    @Override
    public void drawLine() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Row[] getRow() {
        return rows;
    }
}
