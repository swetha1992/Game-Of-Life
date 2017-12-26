package GameOfLife.Model;

public class Cell {
    int positionX;
    int positionY;
    VitalityOfCell status;

    public Cell(int positionX, int positionY, VitalityOfCell status) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = status;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public VitalityOfCell getStatus() {
        return status;
    }

    public void setStatus(VitalityOfCell status) {
        this.status = status;
    }
}
