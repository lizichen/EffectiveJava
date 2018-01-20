package scropio0zry_csdn;

/**
 * http://blog.csdn.net/scropio0zry/article/details/78522498
 */
public class Vertex {
    private char vertex;
    private Side side;

    public Vertex() {
        super();
        this.vertex = '\0';
        this.side = null;
        // TODO Auto-generated constructor stub
    }
    public Vertex(char vertex, Side first) {
        super();
        this.vertex = vertex;
        this.side = first;
    }

    public char getVertex() {
        return vertex;
    }
    public void setVertex(char vertex) {
        this.vertex = vertex;
    }
    public Side getSide() {
        return side;
    }
    public void setSide(Side first) {
        this.side = first;
    }
}
