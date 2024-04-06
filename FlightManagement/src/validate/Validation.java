/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class Validation {

    public static boolean checkNullString(String str) {
        return str.trim().isEmpty();
    }

    public static boolean checkDatePattern(String str) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dtf.parse(str);
            return true;           
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkNumPattern(String flNum) {
        try {
            if (flNum.startsWith("F") || flNum.matches("d{4}")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
