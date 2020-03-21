package minesweeperGame;

public class Cell {

    private Boolean unlocked;
    private Boolean isItBomb;
    private Boolean isItFlagged;
    private int howManyBombsNearBy;
    private int coordinateX;
    private int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.howManyBombsNearBy = 0;
        this.isItBomb = false;
        this.unlocked = false;
        this.isItFlagged = false;
    }

    public void setFlag() {
        this.isItFlagged = true;
    }

    public void setUnlocked() {
        this.unlocked = true;
        this.isItFlagged = false;
    }

    public void setBomb() {
        this.isItBomb = true;
    }

    public void setTheAmountOfBombsNearBy(int howManyBombsNearBy) {
        this.howManyBombsNearBy = howManyBombsNearBy;
    }

    public Boolean getIsItFlagged() {
        return isItFlagged;
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
        if (!this.unlocked && !this.isItFlagged) {
            return "#";
        } else if (this.isItBomb) {
            return "@";
        } else if (this.isItFlagged) {
            return "!";
        } else {
            return "" + this.howManyBombsNearBy;
        }
    }
}
