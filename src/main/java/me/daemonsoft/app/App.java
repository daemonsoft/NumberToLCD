package me.daemonsoft.app;

import me.daemonsoft.exceptions.NumberToLCDException;
import me.daemonsoft.model.SevenSegmentNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author daemonsoft@gmail.com
 * @version 1.0
 * @since 1.8
 */
public class App {

    private static final String EXIT_STRING = "0,0";
    private static final String SPLIT_STRING = ",";
    private static final String BLANK_SPACE = " ";

    public static void main(String[] args) throws NumberToLCDException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        String readedLineString;
        try {
            readedLineString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new NumberToLCDException(NumberToLCDException.READING_LINE_ERROR);
        }
        String[] splitString;
        String numberString;
        int size;
        while (null != readedLineString && !readedLineString.equals(EXIT_STRING)) {
            try {
                splitString = readedLineString.split(SPLIT_STRING);
                size = Integer.parseInt(splitString[0].trim());
                numberString = splitString[1];
            } catch (NumberFormatException nfe) {
                throw new NumberToLCDException(NumberToLCDException.INVALID_SIZE);
            } catch (ArrayIndexOutOfBoundsException ioe) {
                throw new NumberToLCDException(NumberToLCDException.INVALID_NUMBER);
            }
            sevenSegmentNumber.setSize(size);
            //impresíon de cada uno de los niveles del LCD
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0:
                        printHorizontalLevel(sevenSegmentNumber, numberString, i);
                        break;
                    case 1:
                        printVerticalLevel(sevenSegmentNumber, numberString, i);
                        break;
                    case 2:
                        printHorizontalLevel(sevenSegmentNumber, numberString, i);
                        break;
                    case 3:
                        printVerticalLevel(sevenSegmentNumber, numberString, i);
                        break;
                    case 4:
                        printHorizontalLevel(sevenSegmentNumber, numberString, i);
                        break;
                    default:
                        throw new NumberToLCDException(NumberToLCDException.SEGMENT_LEVEL_ERROR);
                }
            }
            try {
                readedLineString = bufferedReader.readLine();
            } catch (IOException e) {
                throw new NumberToLCDException(NumberToLCDException.READING_LINE_ERROR);
            }
        }
    }

    /**
     * Método que imprime en la consola un nivel de símbolos verticales '|' por el tamaño definido de segmento
     *
     * @param sevenSegmentNumber instancia de la clase {@link SevenSegmentNumber}
     * @param numberString       cadena de caracteres que contiene el/los número(s) a imprimir
     * @param level              nivel actual de impresión de el/los número(s) a imprimir
     * @throws NumberToLCDException cuanto se ingresa un caracter diferente a un número
     */
    private static void printVerticalLevel(SevenSegmentNumber sevenSegmentNumber, String numberString, int level) throws NumberToLCDException {
        for (int k = 0; k < sevenSegmentNumber.getSize(); k++) {
            printHorizontalLevel(sevenSegmentNumber, numberString, level);
        }
    }

    /**
     * Método que imprime en la consola un nivel de símbolos horizontales '-'
     *
     * @param sevenSegmentNumber instancia de la clase {@link SevenSegmentNumber}
     * @param numberString       cadena de caracteres que contiene el/los número(s) a imprimir
     * @param level              nivel actual de impresión de el/los número(s) a imprimir
     * @throws NumberToLCDException cuanto se ingresa un caracter diferente a un número
     */
    private static void printHorizontalLevel(SevenSegmentNumber sevenSegmentNumber, String numberString, int level) throws NumberToLCDException {
        int number;
        for (int j = 0; j < numberString.trim().length(); j++) {
            try {
                number = Integer.parseInt(String.valueOf(numberString.trim().charAt(j)));
            } catch (NumberFormatException nfe) {
                throw new NumberToLCDException(NumberToLCDException.INVALID_NUMBER);
            }
            System.out.print(sevenSegmentNumber.getSegmentString(number, level));
            System.out.print(BLANK_SPACE);
        }
        System.out.println();
    }
}
