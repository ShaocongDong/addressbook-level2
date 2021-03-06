package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 *  We split the person's address class into several subclass
 *  Including Block, Street, Unit, and Postal Code
 *  For Street, it is a string representing the person's address street part
 */
public class Street {
    private String streetString;
    private boolean valid;
    private String value;

    private static final String STREET_STRING_CONSTRAINTS = "Street string is a string representing the street";
    private static final String STREET_VALIDATION_REGEX = "[a-zA-Z0-9 ]+";

    /**
     * construct the street object and validate the street string passed in
     * @param inputString
     * @throws IllegalValueException
     */
    public Street ( String inputString ) throws IllegalValueException {
        if (!inputString.isEmpty()) {
            streetString = inputString;
            valid = false;
            if (!isValidStreetString(streetString)) {
                throw new IllegalValueException(STREET_STRING_CONSTRAINTS);
            }
            valid = true;
            value = streetString;
        } else {
            valid = false;
            value = "";
        }
    }

    /**
     * getter to help retrieve the String version of the street
     * This function can return empty String as the street input can be omitted
     * @return the string version of the street
     */
    public String getStreetValue () {
        return value;
    }

    /**
     * validation checker for the street string
     * @param streetString
     * @return true if the street string is in line with the constraints by regex
     */
    public static boolean isValidStreetString ( String streetString ) {
        return (streetString.matches(STREET_VALIDATION_REGEX));
    }

    /**
     * to get the validity of this street object in order to get the valud of it out
     * @return the validity of this street object
     */
    public boolean isValidStreetObject () {
        return valid;
    }

    @Override
    public String toString () {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street)other).getStreetValue())); // state check
    }
}

