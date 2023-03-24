package ladder;

public class MakeLadder {
    int[][] line; // 사다리 배열

    int position;

    public MakeLadder(int below, int player){
        colValidate(below);
        colValidate(player);
        line = new int [below][player];

    } //참여 인원 받고, 참여 인원만큼 가로 줄 만들고, 아래로도 내리기; 여기서 아래로 내려가는게 0이하일 경우와 player 명 수 제한 확인;
    //ex) line[0] -> [0,0,0,0] 참여인원이 4명일 때!

    public void DrawLine(int row, int col){
        if(line[col][row] == 0) {
            line[col][row] = 1;
            line[col][row + 1] = -1;
        }
        //사다리 중간 단계 만들기. 사다리 가로 줄이 연달아 있는 것을 막아주기.

    }

    public void checkNthPosition() {
        if (position > line[0].length) {
            throw new IllegalArgumentException(); //에러 명이 정확하지않음.
        }
        else if(position < 0) {
            throw new IllegalArgumentException();
        }
    }
    //에러 처리. 다음 단계로 넘어가는 칸이 사다리

    public void colValidate(int value){
        if (value < 0)  {
            throw new IllegalArgumentException();
        }
    }
    // 아래 칸 에러처리

    public int Play(int firstposition) {
        position = firstposition;
        for(int i=0; i<line.length; i++){
            checkNthPosition();
            if (line[i][position] == 1){
                position = position +1;
            }

            else if (line[i][position] == -1){
                position = position - 1;
            }

            else if (line[i][position] == 0) {

            }
        }
        return position;


    }
}

