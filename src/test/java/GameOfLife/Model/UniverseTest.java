package GameOfLife.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UniverseTest {

    List<Cell> cells = new ArrayList<>();
    Universe mockUniverse = new Universe(cells);


    @Before
    public void setUp(){
        int maximumOfX = 4;
        int minimumOfX = 2;
        int maximumOfY = 5;
        int minimumOfY = 4;
        for(int positionX=minimumOfX-1;positionX<=maximumOfX+1;positionX++){
            for(int positionY=minimumOfY -1;positionY<=maximumOfY+1;positionY++){
                cells.add(new Cell(positionX,positionY, VitalityOfCell.DEAD));
            }
        }
        cells.remove(5);
        cells.add(new Cell(2,4,VitalityOfCell.ALIVE));
        cells.forEach(cell -> System.out.println(cell.getPositionX()+","+cell.getPositionY()+"," + cell.getStatus()));
        mockUniverse.setCells(cells);
    }

    @Test
    public void shouldVerityVitalityOfCellAtOneCommaThreeIsAlive(){
        Cell cellAtOneCommaThree = cells.stream()
                .filter(cell -> cell.getPositionX() ==1 && cell.getPositionY() ==3)
                .findAny().orElse(null);
        Assert.assertEquals(VitalityOfCell.ALIVE,cellAtOneCommaThree.getStatus());
    }
    @Test
    public void shouldVerityVitalityOfCellAtOneCommaFourIsDead(){
        Cell cellAtOneCommaThree = cells.stream()
                .filter(cell -> cell.getPositionX() ==1 && cell.getPositionY() ==4)
                .findAny().orElse(null);
        Assert.assertEquals(VitalityOfCell.DEAD,cellAtOneCommaThree.getStatus());
    }
    @Test
    public void shouldVerifyIfCountOfNeighbouringVitalCellsIsOneForCellAtThreeCommaFour(){
        Cell cellOneCommaFour = new Cell(3,4,VitalityOfCell.DEAD);
        Assert.assertEquals(1,mockUniverse.determineCountOfLiveNeighbours(cellOneCommaFour));
    }
}
