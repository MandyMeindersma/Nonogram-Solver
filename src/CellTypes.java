package src;

public enum CellTypes {
    UNKNOWN ("_"),
    FILLED ("■"),
    EMPTY ("□");


    private String view;
    CellTypes(String view) {
        this.view = view;
    }
    public String view() { return view; }

}
