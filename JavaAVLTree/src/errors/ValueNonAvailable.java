package errors;

public class ValueNonAvailable extends Throwable {

    public ValueNonAvailable() {
        super("Value does not exists in this AVL Tree");
    }
}
