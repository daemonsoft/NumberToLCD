package me.daemonsoft.model;

import me.daemonsoft.exceptions.NumberToLCDException;

/**
 * @author daemonsoft@gmail.com
 * @version 1.0
 * @since 1.8
 */
public class SevenSegmentNumber {

    private static final char BLANK_SPACE = ' ';
    private static final char HYPHEN = '-';
    private static final char VERTICAL_BAR = '|';
    //cantidad de caracteres por segmentos
    private int size;
    //representación de los números 0-9 en segmentos
    private int[][] activeSegments = {
            {1, 1, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0}, {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1}};

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * Método que retorna un String que contiene la representación en símbolos del nivel de un número
     *
     * @param number número a representar en símbolos
     * @param level  nivel del segmento a representar
     * @return representación en símbolos del nivel de un número
     * @throws NumberToLCDException
     */
    public String getSegmentString(int number, int level) throws NumberToLCDException {
        StringBuilder stringSegment = new StringBuilder();
        switch (level) {
            case 0:
                stringSegment.append(BLANK_SPACE);
                for (byte i = 0; i < this.size; i++) {
                    if (activeSegments[number][0] == 1) stringSegment.append(HYPHEN);
                    else stringSegment.append(BLANK_SPACE);
                }
                stringSegment.append(BLANK_SPACE);
                break;
            case 1:
                if (activeSegments[number][1] == 1) stringSegment.append(VERTICAL_BAR);
                else stringSegment.append(BLANK_SPACE);
                for (byte i = 0; i < this.size; i++) {
                    stringSegment.append(BLANK_SPACE);
                }
                if (activeSegments[number][2] == 1) stringSegment.append(VERTICAL_BAR);
                else stringSegment.append(BLANK_SPACE);
                break;
            case 2:
                stringSegment.append(BLANK_SPACE);
                for (byte i = 0; i < this.size; i++) {
                    if (activeSegments[number][3] == 1) stringSegment.append(HYPHEN);
                    else stringSegment.append(BLANK_SPACE);
                }
                stringSegment.append(BLANK_SPACE);
                break;
            case 3:
                if (activeSegments[number][4] == 1) stringSegment.append(VERTICAL_BAR);
                else stringSegment.append(BLANK_SPACE);
                for (byte i = 0; i < this.size; i++) {
                    stringSegment.append(BLANK_SPACE);
                }
                if (activeSegments[number][5] == 1) stringSegment.append(VERTICAL_BAR);
                else stringSegment.append(BLANK_SPACE);
                break;
            case 4:
                stringSegment.append(BLANK_SPACE);
                for (byte i = 0; i < this.size; i++) {
                    if (activeSegments[number][6] == 1) stringSegment.append(HYPHEN);
                    else stringSegment.append(BLANK_SPACE);
                }
                stringSegment.append(BLANK_SPACE);
                break;
            default:
                throw new NumberToLCDException(NumberToLCDException.SEGMENT_LEVEL_ERROR);
        }
        return stringSegment.toString();
    }
}
