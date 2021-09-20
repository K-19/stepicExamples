package by.k19.robots;

public class Robot {
    private int x, y;
    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    protected int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Robot() {}

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void turnLeft() {
        switch(direction) {
            case UP: direction = Direction.LEFT; break;
            case DOWN: direction = Direction.RIGHT; break;
            case LEFT: direction = Direction.DOWN; break;
            case RIGHT: direction = Direction.UP; break;
        }
    }

    public void turnRight() {
        switch(direction) {
            case UP: direction = Direction.RIGHT; break;
            case DOWN: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.UP; break;
            case RIGHT: direction = Direction.DOWN; break;
        }
    }

    public void stepForward() {
        switch(direction) {
            case UP: y++; break;
            case DOWN: y--; break;
            case LEFT: x--; break;
            case RIGHT: x++; break;
        }
    }

    public void move(int toX, int toY) {
        while(getX() != toX || getY() != toY) {
            int distanceToX = Math.abs(getX() - toX);
            int distanceToY = Math.abs(getY() - toY);
            if  (distanceToX < distanceToY) {
                rotate(toY > getY() ? Direction.UP : Direction.DOWN);
            }
            else rotate(toX > getX() ? Direction.RIGHT : Direction.LEFT);
            stepForward();
            System.out.println("Forwarding!" + this);
        }
    }

    public void rotate(Direction toWay) {
        int pos = 0, goalRight = 0, goalLeft = 0;
        switch(getDirection()) {
            case DOWN: pos = 180; break;
            case LEFT: pos = 270; break;
            case RIGHT: pos = 90; break;
            default:
        }
        switch (toWay) {
            case UP:
                goalRight = 360;
                break;
            case DOWN:
                goalRight = 180;
                goalLeft = -180;
                break;
            case LEFT:
                goalRight = 270;
                goalLeft = -90;
                break;
            case RIGHT:
                goalRight = 90;
                goalLeft = -270;
        }
        int absRight = Math.abs(pos - goalRight);
        int absLeft = Math.abs(pos - goalLeft);
        while(getDirection() != toWay) {
            if (absRight <= absLeft) {
                turnRight();
                System.out.println("Turning right!");
            }
            else {
                turnLeft();
                System.out.println("Turning left!");
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
