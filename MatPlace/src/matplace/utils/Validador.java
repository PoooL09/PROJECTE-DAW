/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PoooL
 */
public class Validador {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean chekMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean checkDNI(String dni) {
        Pattern pat = Pattern.compile("[0-9]{8}[A-Z a-z]");
        Matcher mat = pat.matcher(dni);

        if (!mat.matches()) {
            return mat.matches();

        } else {
            return mat.matches();
        }

    }

    public static boolean checkNumb(String num) {
        if (num.matches("[0-9]*") && num.length() == 9) {
            return true;
        } else {
            return false;
        }
    }
}
