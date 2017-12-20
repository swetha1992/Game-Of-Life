package GameOfLife.Model;

public class Cell {
    int positionX;
    int positionY;
    VitalityOfCell status;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public VitalityOfCell getStatus() {
        return status;
    }

    public Cell(int positionX, int positionY, VitalityOfCell status) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = status;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setStatus(VitalityOfCell status) {
        this.status = status;
    }
}
