package simplegen;

public class Pair <E extends Colored & Sized> {
    private E left;
    private E right;

    public Pair(E left, E right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public E getRight() {
        return right;
    }

    public void setRight(E right) {
        this.right = right;
    }
    
    public boolean match() {
        return left.getColor().equals(right.getColor())
                && left.getSize() == right.getSize();
    }
}
