//name: Thaphat Jirametharat
//ID  : 6510450453
public class Piece {
    private Square location;

    public Piece(Square location) {
        this.location = location;
    }
    public Square getLocation() {
        return location;
    }
    public void setLocation(Square newLoc) {
        this.location = newLoc;
    }
}
