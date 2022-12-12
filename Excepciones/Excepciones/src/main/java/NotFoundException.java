public class NotFoundException extends RuntimeException{
    private final String status="404";

    public NotFoundException(String message)
    {
        super(message);
    }

    String getStatus()
    {
        return status;
    }
}
