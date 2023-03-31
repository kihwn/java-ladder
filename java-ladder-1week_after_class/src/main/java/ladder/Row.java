package ladder;

import static ladder.Position.createPosition;

public class Row {
    Node[] nodes;


    private Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    public static Row createRow(NaturalNumber numberOfPerson) {
        return new Row(numberOfPerson);
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        nodes[startPosition.getPosition()] = Node.createRightNode();
        nodes[startPosition.getPosition() + 1] = Node.createLeftNode();
    }

    public void nextPosition(Position position) {
        validatePositionSize(position);
        nodes[position.getPosition()].move(position);
    }

    private void validatePositionSize(Position position) {
        if (!position.isSmaller(nodes.length)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePositionSize(startPosition);
        if (nodes[startPosition.getPosition()].isLeft() ||
                nodes[startPosition.getPosition() + 1].isRight()) {
            throw new IllegalArgumentException();
        }
    }

    public void printRow(Position position, boolean current) {
        for(int i = 0; i <nodes.length; i++) {
            //현재위치 == 출력하고자 하는 위치가 같다면 *, 아니면 공백찍고 넘어가기
            String S = " ";
            if((current == true) && // 내가 지금 찍고 있는 줄만 별표 처리 하기 위해
                    (position.getPosition() == i)) S = "*";  //처리하고 있는 row들 중 내 현위치(position) 찾기
            System.out.print(nodes[i].getDirection().getDirection() + S); //

        }

    }

}