public class Single {

    public static void main(String[] args) {

        Bungle b = Bungle.instance;
    }
}

class Bungle {

    public static final Bungle instance = new Bungle();

    private Bungle() {

    }
}