public class AlreadyExistsException extends RuntimeException {
//    public AlreadyExistsException(int id) {
//        super("Product with ID " + id + " already exist");
//    }
public AlreadyExistsException(String s) {
        super(s);
    }
}
