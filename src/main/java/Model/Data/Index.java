package Model.Data;

/**
 * The main storage for user input.
 */
public class Index {
    private static Index instance = null;
    private int index = -1;

    /**
     * Default Index constructor.
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     */
    private Index() {
    }

    /**
     * Simple accessor for Index instance<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * User retrieves stored index instance.<br>
     *
     * @return The Index instance.
     */
    public static Index getInstance() {
        if (instance == null) {
            instance = new Index();
        }
        return instance;
    }

    /**
     * Simple setter for the users input<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @param number The users input.
     */
    public void setIndex(int number) {
        this.index = number;
    }

    /**
     * Simple accessor for the users input<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The users input.
     */
    public int getIndex() {
        return this.index;
    }
}
