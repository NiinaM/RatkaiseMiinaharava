package minesweeperGame;

public class Cell {

    private Boolean unlocked;
    private Boolean isItBomb;
    private int howManyBombsNearBy;
    private int coordinateX;
    private int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.isItBomb = false;
        this.howManyBombsNearBy = 0;
        this.unlocked = false;
    }

    public void setUnlocked() {
        this.unlocked = true;
    }

    public void setBomb() {
        this.isItBomb = true;
    }

    public void setTheAmountOfBombsNearBy(int howManyBombsNearBy) {
        this.howManyBombsNearBy = howManyBombsNearBy;
    }

    public Integer getCoordinateX() {
        return this.coordinateX;
    }

    public Integer getCoordinateY() {
        return this.coordinateY;
    }

    public Integer getHowManyBombsNearBy() {
        return this.howManyBombsNearBy;
    }

    public Boolean getIsItBomb() {
        return this.isItBomb;
    }

    public Boolean getUnlocked() {
        return this.unlocked;
    }

    @Override
    public String toString() {
        if(this.isItBomb) {
            return "#";
        }
        return "" + this.howManyBombsNearBy;
    }
}
