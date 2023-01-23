package co.kr.school.programmers.codingtest.lessons.lv2;

import java.util.*;

/**
 * 빛의 경로 사이클
 * 문제 설명
 * 각 칸마다 S, L, 또는 R가 써져 있는 격자가 있습니다. 당신은 이 격자에서 빛을 쏘고자 합니다. 이 격자의 각 칸에는 다음과 같은 특이한 성질이 있습니다.
 *
 * 빛이 "S"가 써진 칸에 도달한 경우, 직진합니다.
 * 빛이 "L"이 써진 칸에 도달한 경우, 좌회전을 합니다.
 * 빛이 "R"이 써진 칸에 도달한 경우, 우회전을 합니다.
 * 빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아옵니다. 예를 들어, 빛이 1행에서 행이 줄어드는 방향으로 이동할 경우, 같은 열의 반대쪽 끝 행으로 다시 돌아옵니다.
 * 당신은 이 격자 내에서 빛이 이동할 수 있는 경로 사이클이 몇 개 있고, 각 사이클의 길이가 얼마인지 알고 싶습니다. 경로 사이클이란, 빛이 이동하는 순환 경로를 의미합니다.
 *
 * 예를 들어, 다음 그림은 격자 ["SL","LR"]에서 1행 1열에서 2행 1열 방향으로 빛을 쏠 경우, 해당 빛이 이동하는 경로 사이클을 표현한 것입니다.
 *
 * ex1.png
 *
 * 이 격자에는 길이가 16인 사이클 1개가 있으며, 다른 사이클은 존재하지 않습니다.
 *
 * 격자의 정보를 나타내는 1차원 문자열 배열 grid가 매개변수로 주어집니다. 주어진 격자를 통해 만들어지는 빛의 경로 사이클의 모든 길이들을 배열에 담아 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ grid의 길이 ≤ 500
 * 1 ≤ grid의 각 문자열의 길이 ≤ 500
 * grid의 모든 문자열의 길이는 서로 같습니다.
 * grid의 모든 문자열은 'L', 'R', 'S'로 이루어져 있습니다.
 * 입출력 예
 * grid	result
 * ["SL","LR"]	[16]
 * ["S"]	[1,1,1,1]
 * ["R","R"]	[4,4]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 같습니다.
 * 길이가 16인 사이클이 하나 존재하므로(다른 사이클은 없습니다.), [16]을 return 해야 합니다.
 * 입출력 예 #2
 *
 * 주어진 격자를 통해 만들 수 있는 사이클들은 다음 그림과 같습니다.
 * ex2.png
 *
 * 4개의 사이클의 길이가 모두 1이므로, [1,1,1,1]을 return 해야 합니다.
 * 입출력 예 #3
 *
 * 주어진 격자를 통해 만들 수 있는 사이클들은 다음 그림과 같습니다.
 * ex3.png
 *
 * 2개의 사이클의 길이가 모두 4이므로, [4,4]를 return 해야 합니다.
 */

public class Lesson_86052_new {
    int[] answer = {};

    public Lesson_86052_new(String[] grid) {
        answer = solution(grid);
    }

    public int[] getAnswer() {
        return answer;
    }

    private int[] solution(String[] grid) {
        List<Integer> cycleList = new ArrayList<>();
        List<Prism_new> prismList = new ArrayList<>();

        final int MAX_X = grid[0].split("").length;
        final int MAX_Y = grid.length;
        Prism_new[][] prisms = setPrisms(grid, MAX_X, MAX_Y, prismList);

        Position_new nextPrismPosition = getNextPrismPosition(prismList);
        while (nextPrismPosition != null) {

            int lengthOfCycle = 0;
            while (nextPrismPosition != null) {
                try {
                    nextPrismPosition = prisms[nextPrismPosition.getY()][nextPrismPosition.getX()].lightIn(nextPrismPosition.getDirection());
                } catch (LightBlockingException_new ex) {
                    break;
                }
                lengthOfCycle++;
            }

            cycleList.add(lengthOfCycle);
            nextPrismPosition = getNextPrismPosition(prismList);
        }

        Collections.sort(cycleList);
        return cycleList.stream().mapToInt(i -> i).toArray();
    }

    private Prism_new[][] setPrisms(String[] grid, final int MAX_X, final int MAX_Y, List<Prism_new> prismList) {
        Prism_new[][] prisms = new Prism_new[MAX_Y][MAX_X];

        int y = 0;
        for (String yList : grid) {
            int x = 0;
            String[] xList = yList.split("");
            for (String prism : xList) {
                switch (prism) {
                    case "S":
                        prisms[y][x] = new S_new(x, y, MAX_X, MAX_Y);
                        break;
                    case "L":
                        prisms[y][x] = new L_new(x, y, MAX_X, MAX_Y);
                        break;
                    case "R":
                        prisms[y][x] = new R_new(x, y, MAX_X, MAX_Y);
                        break;
                }
                prismList.add(prisms[y][x]);
                x++;
            }
            y++;
        }

        return prisms;
    }

    private Position_new getNextPrismPosition(List<Prism_new> prismList) {
        Iterator<Prism_new> prisms = prismList.iterator();

        while (prisms.hasNext()) {
            Prism_new prism = prisms.next();

            if (prism.OUT_TOP == null) {
                return prism.refraction(prism.findFromDirection(DIRECTION_new.TOP));
            } else if (prism.OUT_LEFT == null) {
                return prism.refraction(prism.findFromDirection(DIRECTION_new.LEFT));
            } else if (prism.OUT_RIGHT == null) {
                return prism.refraction(prism.findFromDirection(DIRECTION_new.RIGHT));
            } else if (prism.OUT_BOTTOM == null) {
                return prism.refraction(prism.findFromDirection(DIRECTION_new.BOTTOM));
            }

            prisms.remove();
        }

        return null;
    }
}

class LightBlockingException_new extends RuntimeException {
    LightBlockingException_new(String message) {
        super(message);
    }
}

enum DIRECTION_new {
    TOP, LEFT, RIGHT, BOTTOM;
}

class Position_new {
    private int X;
    private int Y;
    private DIRECTION_new direction;

    public Position_new(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public DIRECTION_new getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION_new direction) {
        this.direction = direction;
    }
}

abstract class Prism_new {
    static int MAX_X;
    static int MAX_Y;
    Position_new position;

    Position_new OUT_TOP;
    Position_new OUT_LEFT;
    Position_new OUT_RIGHT;
    Position_new OUT_BOTTOM;

    abstract public Position_new lightIn(DIRECTION_new fromDirection);
    abstract public Position_new refraction(DIRECTION_new fromDirection);
    abstract public Position_new lightOut(Position_new nextPrismPosition);
    abstract public DIRECTION_new findFromDirection(DIRECTION_new toDirection);
    abstract public String toString();

    public int setLoopPositionX(int nextX) {
        if (nextX >= this.MAX_X) {
            return 0;
        } else if (nextX < 0) {
            return this.MAX_X - 1;
        } else {
            return nextX;
        }
    }

    public int setLoopPositionY(int nextY) {
        if (nextY >= this.MAX_Y) {
            return 0;
        } else if (nextY < 0) {
            return this.MAX_Y - 1;
        } else {
            return nextY;
        }
    }
}

interface Straight_new {
    public Position_new goStraight(DIRECTION_new toDirection);
}
interface Left_new {
    public Position_new turnLeft(DIRECTION_new toDirection);
}
interface Right_new {
    public Position_new turnRight(DIRECTION_new toDirection);
}

class S_new extends Prism_new implements Straight_new{
    public S_new(int myX, int myY, int MAX_X, int MAX_Y) {
        this.position = new Position_new(myX, myY);
        this.MAX_X = MAX_X;
        this.MAX_Y = MAX_Y;
    }

    @Override
    public Position_new lightIn(DIRECTION_new toDirection) throws LightBlockingException_new {
        Position_new nextPrismPosition = refraction(findFromDirection(toDirection));
        return lightOut(nextPrismPosition);
    }

    @Override
    public Position_new refraction(DIRECTION_new fromDirection) {
        return goStraight(fromDirection);
    }

    @Override
    public Position_new lightOut(Position_new nextPrismPosition) throws LightBlockingException_new {
        switch (nextPrismPosition.getDirection()) {
            case TOP:
                if (OUT_TOP == null) {
                    OUT_TOP = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case LEFT:
                if (OUT_LEFT == null) {
                    OUT_LEFT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case RIGHT:
                if (OUT_RIGHT == null) {
                    OUT_RIGHT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case BOTTOM:
                if (OUT_BOTTOM == null) {
                    OUT_BOTTOM = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
        }

        return nextPrismPosition;
    }

    @Override
    public DIRECTION_new findFromDirection(DIRECTION_new toDirection) {
        DIRECTION_new fromDirection = DIRECTION_new.RIGHT;

        switch (toDirection) {
            case TOP:
                fromDirection = DIRECTION_new.BOTTOM;
                break;
            case LEFT:
                fromDirection = DIRECTION_new.RIGHT;
                break;
            case RIGHT:
                fromDirection = DIRECTION_new.LEFT;
                break;
            case BOTTOM:
                fromDirection = DIRECTION_new.TOP;
                break;
        }

        return fromDirection;
    }

    @Override
    public String toString() {
        return "Class = S, x = " + position.getX() + ", y = " + position.getY();
    }

    @Override
    public Position_new goStraight(DIRECTION_new fromDirection) {
        Position_new nextPrismPosition = null;

        switch (fromDirection) {
            case TOP:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() + 1));
                nextPrismPosition.setDirection(DIRECTION_new.BOTTOM);
                break;
            case LEFT:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() + 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.RIGHT);
                break;
            case RIGHT:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() - 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.LEFT);
                break;
            case BOTTOM:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() - 1));
                nextPrismPosition.setDirection(DIRECTION_new.TOP);
                break;
        }

        return nextPrismPosition;
    }
}

class L_new extends Prism_new implements Left_new{
    public L_new(int myX, int myY, int MAX_X, int MAX_Y) {
        this.position = new Position_new(myX, myY);
        this.MAX_X = MAX_X;
        this.MAX_Y = MAX_Y;
    }

    @Override
    public Position_new lightIn(DIRECTION_new fromDirection) throws LightBlockingException_new {
        Position_new nextPrismPosition = refraction(fromDirection);
        return lightOut(nextPrismPosition);
    }

    @Override
    public Position_new refraction(DIRECTION_new fromDirection) {
        return turnLeft(fromDirection);
    }

    @Override
    public Position_new lightOut(Position_new nextPrismPosition) throws LightBlockingException_new {
        switch (nextPrismPosition.getDirection()) {
            case TOP:
                if (OUT_TOP == null) {
                    OUT_TOP = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case LEFT:
                if (OUT_LEFT == null) {
                    OUT_LEFT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case RIGHT:
                if (OUT_RIGHT == null) {
                    OUT_RIGHT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case BOTTOM:
                if (OUT_BOTTOM == null) {
                    OUT_BOTTOM = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
        }

        return nextPrismPosition;
    }

    @Override
    public DIRECTION_new findFromDirection(DIRECTION_new toDirection) {
        DIRECTION_new fromDirection = DIRECTION_new.RIGHT;

        switch (toDirection) {
            case TOP:
                fromDirection = DIRECTION_new.LEFT;
                break;
            case LEFT:
                fromDirection = DIRECTION_new.BOTTOM;
                break;
            case RIGHT:
                fromDirection = DIRECTION_new.TOP;
                break;
            case BOTTOM:
                fromDirection = DIRECTION_new.RIGHT;
                break;
        }

        return fromDirection;
    }

    @Override
    public String toString() {
        return "Class = L, x = " + position.getX() + ", y = " + position.getY();
    }

    @Override
    public Position_new turnLeft(DIRECTION_new fromDirection) {
        Position_new nextPrismPosition = null;

        switch (fromDirection) {
            case TOP:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() + 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.RIGHT);
                break;
            case LEFT:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() - 1));
                nextPrismPosition.setDirection(DIRECTION_new.TOP);
                break;
            case RIGHT:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() + 1));
                nextPrismPosition.setDirection(DIRECTION_new.BOTTOM);
                break;
            case BOTTOM:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() - 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.LEFT);
                break;
        }

        return nextPrismPosition;
    }
}

class R_new extends Prism_new implements Right_new{
    public R_new(int myX, int myY, int MAX_X, int MAX_Y) {
        this.position = new Position_new(myX, myY);
        this.MAX_X = MAX_X;
        this.MAX_Y = MAX_Y;
    }

    @Override
    public Position_new lightIn(DIRECTION_new fromDirection) throws LightBlockingException_new {
        Position_new nextPrismPosition = refraction(fromDirection);
        return lightOut(nextPrismPosition);
    }

    @Override
    public Position_new refraction(DIRECTION_new fromDirection) {
        return turnRight(fromDirection);
    }

    @Override
    public Position_new lightOut(Position_new nextPrismPosition) throws LightBlockingException_new {
        switch (nextPrismPosition.getDirection()) {
            case TOP:
                if (OUT_TOP == null) {
                    OUT_TOP = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case LEFT:
                if (OUT_LEFT == null) {
                    OUT_LEFT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case RIGHT:
                if (OUT_RIGHT == null) {
                    OUT_RIGHT = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
            case BOTTOM:
                if (OUT_BOTTOM == null) {
                    OUT_BOTTOM = nextPrismPosition;
                } else {
                    throw new LightBlockingException_new("이미 빛이 지나간 경로 입니다.");
                }
                break;
        }

        return nextPrismPosition;
    }

    @Override
    public DIRECTION_new findFromDirection(DIRECTION_new toDirection) {
        DIRECTION_new fromDirection = DIRECTION_new.RIGHT;

        switch (toDirection) {
            case TOP:
                fromDirection = DIRECTION_new.RIGHT;
                break;
            case LEFT:
                fromDirection = DIRECTION_new.TOP;
                break;
            case RIGHT:
                fromDirection = DIRECTION_new.BOTTOM;
                break;
            case BOTTOM:
                fromDirection = DIRECTION_new.LEFT;
                break;
        }

        return fromDirection;
    }

    @Override
    public String toString() {
        return "Class = R, x = " + position.getX() + ", y = " + position.getY();
    }

    @Override
    public Position_new turnRight(DIRECTION_new fromDirection) {
        Position_new nextPrismPosition = null;

        switch (fromDirection) {
            case TOP:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() - 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.LEFT);
                break;
            case LEFT:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() + 1));
                nextPrismPosition.setDirection(DIRECTION_new.BOTTOM);
                break;
            case RIGHT:
                nextPrismPosition = new Position_new(position.getX(), setLoopPositionY(position.getY() - 1));
                nextPrismPosition.setDirection(DIRECTION_new.TOP);
                break;
            case BOTTOM:
                nextPrismPosition = new Position_new(setLoopPositionX(position.getX() + 1), position.getY());
                nextPrismPosition.setDirection(DIRECTION_new.RIGHT);
                break;
        }

        return nextPrismPosition;
    }
}