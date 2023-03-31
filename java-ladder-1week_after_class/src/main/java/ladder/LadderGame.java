package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }


    //position 처음 출발하는 위치 지정
    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRow());
        ladderRunner.run(position);

        return position.getPosition();
    }
}
