package Game;

public enum Candies {
    BLUECANDY("/Objects/blueCandy.png", 1),
    GREENCANDY("/Objects/greenCandy.png", 2),
    REDCANDY("/Objects/redCandy.png", 3),
    YELLOWNDY("/Objects/yellowCandy.png", 4),
    PURPLECANDY("/Objects/purpleCandy.png", 5);

    public String path;
    public int val;

    Candies(String path, int val) {
        this.path = path;
        this.val = val;
    }
}
