package GameOfLife.Model;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    List<Cell> cells;

    public Universe(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }
    public VitalityOfCell getVitalityOfCellAt(int positionX, int positionY){
        Cell cell = getCells().stream().filter(cellInUniverse -> cellInUniverse.getPositionX()==positionX && cellInUniverse.getPositionY() == positionY).findAny().orElse(null);
        if(cell==null)
            return VitalityOfCell.DEAD;
        return cell.getStatus();

    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int determineCountOfLiveNeighbours(Cell cell){
        int positionX= cell.getPositionX();
        int positionY = cell.getPositionY();
        List<VitalityOfCell> vitalityOfNeighbouringCells = new ArrayList<>();
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX,positionY-1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX+1,positionY-1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX+1,positionY));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX+1,positionY+1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX,positionY+1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX-1,positionY+1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX-1,positionY));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX-1,positionY-1));
        vitalityOfNeighbouringCells.add(getVitalityOfCellAt(positionX+1,positionY));
        return (int) vitalityOfNeighbouringCells.stream().filter(vitalityOfCell -> vitalityOfCell.equals(vitalityOfCell.ALIVE)).count();
    }
}

