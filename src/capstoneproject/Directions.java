package capstoneproject;

public enum Directions {
    N, S, W, E;

    public Directions getOpposite(){
        return switch(this){
            case E -> W;
            case N -> S;
            case W -> E;
            case S -> N;
        };
    }
}
