package GameOfLife.Game;


import GameOfLife.Exceptions.InvalidCoordinatesException;
import GameOfLife.Model.Cell;
import GameOfLife.Model.Universe;
import GameOfLife.Model.VitalityOfCell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {
    List<Cell> aliveCells;
    public Game(List<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public Boolean validateInputCoordinates(List<Cell> cells) throws InvalidCoordinatesException {
        if(cells.stream().filter(cell -> cell.getPositionX()<=0 || cell.getPositionY() <=0).count()==0)
            return true;
        throw new InvalidCoordinatesException("Please enter positive coordinates");
    }

    public int determineMaximunOfXCoordinates(){
        return aliveCells.stream().max(compareX()).get().getPositionX();
    }

    public int determineMinimumOfXCoordinates(){

        return aliveCells.stream().min(compareX()).get().getPositionX();

    }
    public int determineMaximunOfYCoordinates(){
       return aliveCells.stream().max(compareY()).get().getPositionY();

    }

    public int determineMinimumOfYCoordinates(){
        return aliveCells.stream().min(compareY()).get().getPositionY();
    }

    private Comparator<Cell> compareX(){
        final Comparator<Cell> compX = (cellOne, cellTwo) -> Integer.compare(cellOne.getPositionX(), cellTwo.getPositionX());
        return compX;
    }
    private Comparator<Cell> compareY(){
        final Comparator<Cell> compY = (cellOne, cellTwo) -> Integer.compare(cellOne.getPositionY(), cellTwo.getPositionY());
        return compY;
    }

    public Universe buildUniverse(){
        int maximumOfX = determineMaximunOfXCoordinates();
        int minimumOfX = determineMinimumOfXCoordinates();
        int maximumOfY = determineMaximunOfYCoordinates();
        int minimumOfY = determineMinimumOfYCoordinates();
        List<Cell> cells = new ArrayList<>();
        for(int positionX=minimumOfX-1;positionX<=maximumOfX+1;positionX++){
            for(int positionY=minimumOfY -1;positionY<=maximumOfY+1;positionY++){
                if (isCellVital(positionX,positionY)){
                    cells.add(new Cell(positionX,positionY, VitalityOfCell.ALIVE));
                }else{
                    cells.add(new Cell(positionX,positionY, VitalityOfCell.DEAD));
                }
            }
        }
        return new Universe(cells);
    }
    private Boolean isCellVital(int positionX,int positionY){
        for (Cell cell : aliveCells){
            if(cell.getPositionX() == positionX && cell.getPositionY() == positionY){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void play() {
        makeTransitionOn(buildUniverse());
    }

    public Universe makeTransitionOn(Universe universe) {
        for (Cell cell : universe.getCells()){
            applyTransitionOn(cell);
        }
        return universe;
    }

    private void applyTransitionOn(Cell cell) {
        int countOfLiveNeighbours = buildUniverse().determineCountOfLiveNeighbours(cell);
        if (cell.getStatus().equals(VitalityOfCell.ALIVE)) {
            if (countOfLiveNeighbours < 2 || countOfLiveNeighbours > 3) {
                cell.setStatus(VitalityOfCell.DEAD);
            }
        }else if(cell.getStatus().equals(VitalityOfCell.DEAD)){
            if(countOfLiveNeighbours ==3){
                cell.setStatus(VitalityOfCell.ALIVE);
            }
        }
    }
}
