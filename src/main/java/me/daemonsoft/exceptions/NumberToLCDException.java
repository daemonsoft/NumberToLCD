package me.daemonsoft.exceptions;

/**
 * @author daemonsoft@gmail.com
 * @version 1.0
 * @since 1.8
 */
public class NumberToLCDException extends Exception {
    public static final String SEGMENT_LEVEL_ERROR = "Error en el nivel de segmentos";
    public static final String READING_LINE_ERROR = "Error de lectura en la linea de entrada";
    public static final String INVALID_SIZE = "Tamaño no válido";
    public static final String INVALID_NUMBER = "Número no válido";

    public NumberToLCDException(String message) {
        super(message);
    }
}
