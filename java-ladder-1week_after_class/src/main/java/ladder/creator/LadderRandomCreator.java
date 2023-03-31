package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

import java.util.Random;

import static ladder.Position.createPosition;
import static ladder.Row.createRow;

public class LadderRandomCreator implements LadderCreator {
    private final int BLOCKNUM; //장애물개수
    LadderDirectlyCreator ladderDirectlyCreator; //사다리 기둥 만들기용
    NaturalNumber numberOfPerson;

    public LadderRandomCreator(NaturalNumber row, NaturalNumber numberOfPerson) {
        BLOCKNUM = (int) (row.getNumber() * numberOfPerson.getNumber() * 0.3);
        this.numberOfPerson = numberOfPerson;
        ladderDirectlyCreator = new LadderDirectlyCreator(row, numberOfPerson); //기둥생성 완료
    }

    @Override
    public void drawLine() {

        Random random = new Random(); //정적팩토리 메서드 사용 부분. ******************* 랜덤에서 seed 재설정 수정.
        for(int i = 0; i < BLOCKNUM; i++) {
            Position row = createPosition(random.nextInt(ladderDirectlyCreator.getRow().length - 1)); //
            Position col = createPosition(random.nextInt(numberOfPerson.getNumber() - 1));

            try {
                ladderDirectlyCreator.drawLine(row, col);
            } catch (IllegalArgumentException e) {
                i -= 1;
            }
            //제일 가생이 부분이나 한줄로 겹치는 예외 발생시 예외처리 하지말고 그냥 다시 for문 돌아.
            // ************HashSet 검색해보기(중복 허용않는 자료구조 형식)********************
        }

    }

    @Override
    public void drawLine(Position row, Position col) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Row[] getRow() {
        return ladderDirectlyCreator.getRow();
    }




}
