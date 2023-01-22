package co.kr.school.programmers.codingtest.lessons.lv2;

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

public class Lesson_86052 {
    int[] answer = {};

    public Lesson_86052(String[] grid) {
        answer = solution(grid);
    }

    public int[] getAnswer() {
        return answer;
    }

    private int[] solution(String[] grid) {

        // -------------------[ 문제풀이 방향성 설정 ]------------------------------------------------------
        // 방향성 1)
        // 한번 지나간 경로는 다신 통과하지 못하도록 막고,
        // 진행 중 막히는 곳을 만나면 1 cycle이 종료된 것으로 간주.
        //-----------------------------------------------------------------------------------------------
        // 방향성 2)
        // 격자 중 임의의 하나를 기준으로 잡고 4방향으로 빛을 한번씩 쏴보면 될 것으로 추측됨.
        //   ===> 해당 가설은 폐기하고 3)항 으로 대체
        //-----------------------------------------------------------------------------------------------
        // 방향성 3)
        // 1)항의 경로 통과 못하도록 막는 로직을 전역변수용으로도 하나 따로 보관하고 있으면서
        // 임의의 격자를 선택하여 one cycle 작업이 끝난 경우, 2)항 처럼 격자 하나에서 4방향으로 빛을 쏘는게 아니라,
        // 전역변수에 저장되어 있던 격자별 경로 통과 여부 값 참조하여, 아직 한 번도 통과한 적이 없는 격자를 찾아
        // 빛을 쏘는 형태로 해야할 듯 함.
        //-----------------------------------------------------------------------------------------------
//        S s = new S(0, 0);
//        try {
//            PositionVO next = s.lightIn(-1, 0);
//        } catch (LightBlockingException ex) {
//            // 1 cycle 종료
//            System.out.println(ex.getMessage());
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
        Prism[][] prisms = setPrisms(grid);

        for (Prism[] list : prisms) {
            for (Prism prism : list) {
                System.out.println("prism = " + prism.toString());
            }
        }

        return new int[] {};
    }

    private Prism[][] setPrisms(String[] grid) {
        int height = grid.length;
        int width = grid[0].split("").length;
        Prism[][] prisms = new Prism[height][width];

        int y = 0;
        for (String xList : grid) {
            int x = 0;
            String[] prismList = xList.split("");
            for (String prism : prismList) {
                switch (prism) {
                    case "S":
                        prisms[y][x] = new S(x, y);
                        break;
                    case "L":
                        prisms[y][x] = new L(x, y);
                        break;
                    case "R":
                        prisms[y][x] = new R(x, y);
                        break;
                }
                x++;
            }
            y++;
        }

        return prisms;
    }
}

class S extends Prism implements Straight, Refraction{
    public S(int myX, int myY) {
        this.position = new PositionVO(myX, myY);
    }

    @Override
    public PositionVO lightIn(int fromX, int fromY) throws Exception {
        PositionVO nextPosition = refraction(fromX, fromY);

        switch (nextPosition.getDirection()) {
            case TOP:
                if(OUT_TOP != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case LEFT:
                if(OUT_LEFT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case RIGHT:
                if(OUT_RIGHT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case BOTTOM:
                if(OUT_BOTTOM != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
        }

        return lightOut(nextPosition);
    }

    @Override
    public PositionVO refraction(int fromX, int fromY) throws Exception {
        return goStraight(fromX, fromY);
    }

    @Override
    public PositionVO lightOut(PositionVO nextPosition) {
        switch (nextPosition.getDirection()) {
            case TOP:
                this.OUT_TOP = nextPosition;
                break;
            case LEFT:
                this.OUT_LEFT = nextPosition;
                break;
            case RIGHT:
                this.OUT_RIGHT = nextPosition;
                break;
            case BOTTOM:
                this.OUT_BOTTOM = nextPosition;
                break;
        }
        return nextPosition;
    }

    public PositionVO goStraight(int fromX, int fromY) throws Exception{
        PositionVO nextDirection;

        switch (directing(fromX, fromY)) {
            case TOP:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() - 1);
                nextDirection.setDirection(DIRECTION.TOP);
                break;
            case LEFT:
                nextDirection = new PositionVO(this.position.getX() - 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.LEFT);
                break;
            case RIGHT:
                nextDirection = new PositionVO(this.position.getX() + 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.RIGHT);
                break;
            case BOTTOM:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() + 1);
                nextDirection.setDirection(DIRECTION.BOTTOM);
                break;
            default:
                throw new Exception("존재하지 않는 진행방향 입니다.");
        }

        return nextDirection;
    }

    @Override
    public DIRECTION directing(int fromX, int fromY) throws Exception {
        int diffX = this.position.getX() - fromX;
        int diffY = this.position.getY() - fromY;

        if (diffX > 0) {
            return DIRECTION.RIGHT;
        } else if (diffX < 0) {
            return DIRECTION.LEFT;
        } else if (diffY > 0) {
            return DIRECTION.BOTTOM;
        } else if (diffY < 0) {
            return DIRECTION.TOP;
        } else {
            throw new Exception("x, y 좌표 값에 이상이있어 빛의 진행방향을 알 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Class = S, x = " + this.position.getX() + ", y = " + this.position.getY();
    }
}

class L extends Prism implements Left, Refraction{
    public L(int myX, int myY) {
        this.position = new PositionVO(myX, myY);
    }

    @Override
    public PositionVO lightIn(int fromX, int fromY) throws Exception {
        PositionVO nextPosition = refraction(fromX, fromY);

        switch (nextPosition.getDirection()) {
            case TOP:
                if(OUT_TOP != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case LEFT:
                if(OUT_LEFT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case RIGHT:
                if(OUT_RIGHT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case BOTTOM:
                if(OUT_BOTTOM != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
        }

        return lightOut(nextPosition);
    }

    @Override
    public PositionVO refraction(int fromX, int fromY) throws Exception {
        return turnLeft(fromX, fromY);
    }

    @Override
    public PositionVO lightOut(PositionVO nextPosition) {
        switch (nextPosition.getDirection()) {
            case TOP:
                this.OUT_TOP = nextPosition;
                break;
            case LEFT:
                this.OUT_LEFT = nextPosition;
                break;
            case RIGHT:
                this.OUT_RIGHT = nextPosition;
                break;
            case BOTTOM:
                this.OUT_BOTTOM = nextPosition;
                break;
        }
        return nextPosition;
    }

    public PositionVO turnLeft(int fromX, int fromY) throws Exception{
        PositionVO nextDirection;

        switch (directing(fromX, fromY)) {
            case TOP:
                nextDirection = new PositionVO(this.position.getX() + 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.RIGHT);
                break;
            case LEFT:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() - 1);
                nextDirection.setDirection(DIRECTION.TOP);
                break;
            case RIGHT:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() + 1);
                nextDirection.setDirection(DIRECTION.BOTTOM);
                break;
            case BOTTOM:
                nextDirection = new PositionVO(this.position.getX() - 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.LEFT);
                break;
            default:
                throw new Exception("존재하지 않는 진행방향 입니다.");
        }

        return nextDirection;
    }

    @Override
    public DIRECTION directing(int fromX, int fromY) throws Exception {
        int diffX = this.position.getX() - fromX;
        int diffY = this.position.getY() - fromY;

        if (diffX > 0) {
            return DIRECTION.RIGHT;
        } else if (diffX < 0) {
            return DIRECTION.LEFT;
        } else if (diffY > 0) {
            return DIRECTION.BOTTOM;
        } else if (diffY < 0) {
            return DIRECTION.TOP;
        } else {
            throw new Exception("x, y 좌표 값에 이상이있어 빛의 진행방향을 알 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Class = L, x = " + this.position.getX() + ", y = " + this.position.getY();
    }
}

class R extends Prism implements Right, Refraction{
    public R(int myX, int myY) {
        this.position = new PositionVO(myX, myY);
    }

    @Override
    public PositionVO lightIn(int fromX, int fromY) throws Exception {
        PositionVO nextPosition = refraction(fromX, fromY);

        switch (nextPosition.getDirection()) {
            case TOP:
                if(OUT_TOP != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case LEFT:
                if(OUT_LEFT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case RIGHT:
                if(OUT_RIGHT != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
            case BOTTOM:
                if(OUT_BOTTOM != null) throw new LightBlockingException("이미 빛이 지나간 경로 입니다.");
                break;
        }

        return lightOut(nextPosition);
    }

    @Override
    public PositionVO refraction(int fromX, int fromY) throws Exception {
        return turnRight(fromX, fromY);
    }

    @Override
    public PositionVO lightOut(PositionVO nextPosition) {
        switch (nextPosition.getDirection()) {
            case TOP:
                this.OUT_TOP = nextPosition;
                break;
            case LEFT:
                this.OUT_LEFT = nextPosition;
                break;
            case RIGHT:
                this.OUT_RIGHT = nextPosition;
                break;
            case BOTTOM:
                this.OUT_BOTTOM = nextPosition;
                break;
        }
        return nextPosition;
    }

    public PositionVO turnRight(int fromX, int fromY) throws Exception{
        PositionVO nextDirection;

        switch (directing(fromX, fromY)) {
            case TOP:
                nextDirection = new PositionVO(this.position.getX() - 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.LEFT);
                break;
            case LEFT:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() + 1);
                nextDirection.setDirection(DIRECTION.BOTTOM);
                break;
            case RIGHT:
                nextDirection = new PositionVO(this.position.getX(), this.position.getY() - 1);
                nextDirection.setDirection(DIRECTION.TOP);
                break;
            case BOTTOM:
                nextDirection = new PositionVO(this.position.getX() + 1, this.position.getY());
                nextDirection.setDirection(DIRECTION.RIGHT);
                break;
            default:
                throw new Exception("존재하지 않는 진행방향 입니다.");
        }

        return nextDirection;
    }

    @Override
    public DIRECTION directing(int fromX, int fromY) throws Exception {
        int diffX = this.position.getX() - fromX;
        int diffY = this.position.getY() - fromY;

        if (diffX > 0) {
            return DIRECTION.RIGHT;
        } else if (diffX < 0) {
            return DIRECTION.LEFT;
        } else if (diffY > 0) {
            return DIRECTION.BOTTOM;
        } else if (diffY < 0) {
            return DIRECTION.TOP;
        } else {
            throw new Exception("x, y 좌표 값에 이상이있어 빛의 진행방향을 알 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Class = R, x = " + this.position.getX() + ", y = " + this.position.getY();
    }
}

enum DIRECTION {
    TOP, LEFT, RIGHT, BOTTOM;
}

class PositionVO {
    private int X;
    private int Y;
    private DIRECTION direction;

    public PositionVO(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
}

abstract class Prism {
    final static int MAX_X = 10;
    final static int MAX_Y = 10;

    PositionVO position;

    PositionVO OUT_TOP;
    PositionVO OUT_LEFT;
    PositionVO OUT_RIGHT;
    PositionVO OUT_BOTTOM;

    abstract public PositionVO lightIn(int fromX, int fromY) throws Exception;
    abstract public PositionVO refraction(int fromX, int fromY) throws Exception;
    abstract public PositionVO lightOut(PositionVO nextPosition);
    abstract public String toString();
}

interface Straight {
    public PositionVO goStraight(int fromX, int fromY) throws Exception;
}
interface Left {
    public PositionVO turnLeft(int fromX, int fromY) throws Exception;
}
interface Right {
    public PositionVO turnRight(int fromX, int fromY) throws Exception;
}

interface Refraction {
    public DIRECTION directing(int fromX, int fromY) throws Exception;
}
class LightBlockingException extends RuntimeException {
    LightBlockingException(String message) {
        super(message);
    }
}