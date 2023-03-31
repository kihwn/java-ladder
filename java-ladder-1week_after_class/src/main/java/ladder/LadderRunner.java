package ladder;
//제가 각색했습니다. 정우님.
public class LadderRunner { //사다리 타고 길따라 내려가기

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printLadder(position, i); //출력 후

            rows[i].nextPosition(position); // 그 다음 위치로 이동


            System.out.println("After");
            printLadder(position, i);
        }

        return position.getPosition();

    }

    //currentRow는 현재 내가 찍고 있는 row.
    public void printLadder(Position position, int currentRow) {
        for (int i = 0; i < rows.length; i++) {
            if(i == currentRow){
                rows[i].printRow(position, true); //별표 찍기용
            }
            if(i != currentRow) {
                rows[i].printRow(position, false);
            }
            System.out.println();
        }

        System.out.println();
    }
}
