package hu.tmx.mybooksapp.exception;

public class ListItemNotFoundException extends Exception{

    public ListItemNotFoundException(){
        super("Item not found");
    }
}
