package com.octa.farouq.octacalculator;

/**
 * Created by farouqzakwan on his happy day
 */
public class OctaConverter {
    private int octaNumber;
    private int decimalNumber;
    private String octaString;

    public OctaConverter(){
    }
// setter and getter
    public int getOctaNumber() {
        return octaNumber;
    }

    public void setOctaNumber(int octaNumber) {
        this.octaString = ""+octaNumber;
        this.octaNumber = octaNumber;
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getOctaString() {
        return octaString;
    }

    public void setOctaString(String octaString) {
        this.octaString = octaString;
    }

    // public method to be used in other class
    public int toDecimal(){
        int decimal = convertToDecimal();
        return decimal;
    }

    public int toOcta(){
        int octa = convertToOcta();
        return octaNumber;
    }

//private method to be used only in this class
    private int convertToDecimal(){
        //all logic parts to convert the number

        //1. get the value first..
        String octa = getOctaString();

        //2. logic for converting from base 8 to base 10...
        int octaSize = octa.length();
        int newValue = 0;

        for(int i=0; i < octaSize; i++){
            double temp = 0;
            String octaChar;
            int charint;
            //07

            //loop every character in the octastring..
                //1.convert character to the number Integer.parseInt(char);
                octaChar = ""+octa.charAt(i);
                charint =Integer.parseInt(octaChar);
                //2.calculate the temp = char + 8^(octaSize - 1 - i)
                int x = octaSize-1-i;
                double y = Math.pow(8, x);

                temp = charint * y;
                //3. newValue += temp...
            newValue+=temp;
        }
        return newValue;
    }
    //[TODO] doit please
    private int convertToOcta(){
        //all logic for converting decimal to octa
        //1. get the decimal first
        int decimal = getDecimalNumber();

        //2. logic for converting from base 10 to base 8..
        return 0;
    }
}
