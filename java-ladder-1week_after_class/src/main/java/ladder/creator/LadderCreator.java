package ladder.creator;
import ladder.Position;
import ladder.Row;


public interface LadderCreator{
    //interface를 사용 시 외부에서 의존성을 주입할 수 있음.


    public void drawLine(Position row, Position col);

    public void drawLine();
    public Row[] getRow();

}
