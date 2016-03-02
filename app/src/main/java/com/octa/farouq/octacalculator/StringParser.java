package com.octa.farouq.octacalculator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * not created by me..shame of you
 */
public class StringParser {
    private static List<Character> getSymbols(String string)
    {
        List<Character> listOfSymbols=new LinkedList<Character>();
        for(int i=0;i<string.length();i++)
        {
            char symbol=string.charAt(i);

            if(symbol=='-' || symbol=='+' || symbol=='*' || symbol=='/')
            {
                listOfSymbols.add(symbol);
            }
        }
        return listOfSymbols;
    }

    private static List<String> getOperands(String string)
    {
        String[] operandsArray=string.split("-|\\+|\\*|\\/");
        List<String> listOfOperands=new LinkedList<String>();

        for(int i=0;i<operandsArray.length;i++)
            listOfOperands.add(operandsArray[i]);

        return listOfOperands;
    }

    private static void listUpdater(List<Character> listOfSymbols,List<String> listOfOperands,int position,float result)
    {
        listOfSymbols.remove(position);
        listOfOperands.remove(position);
        listOfOperands.remove(position);
        listOfOperands.add(position,String.valueOf(result));
        //System.out.println("===========================================================================");
    }

    public static float getAnswer(String string)
    {
        List<Character> listOfSymbols=getSymbols(string);
        List<String> listOfOperands=getOperands(string);
        int operationCount=listOfSymbols.size();
        float operand1=0.0F;
        float operand2=0.0F;
        float result=0.0F;

        while(operationCount>0)
        {
            if(listOfSymbols.contains('*') || listOfSymbols.contains('/'))
            {
                int currentPositionMultiplication=listOfSymbols.indexOf('*');
                int currentPositionDividation=listOfSymbols.indexOf('/');

                if((currentPositionMultiplication<currentPositionDividation && currentPositionMultiplication!=-1) || currentPositionDividation==-1)
                {
                    operand1=Float.parseFloat(listOfOperands.get(currentPositionMultiplication));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionMultiplication+1));
                    result=operand1*operand2;

                    listUpdater(listOfSymbols,listOfOperands,currentPositionMultiplication,result);
                }
                else if((currentPositionMultiplication>currentPositionDividation && currentPositionDividation!=-1) || currentPositionMultiplication==-1)
                {
                    operand1=Float.parseFloat(listOfOperands.get(currentPositionDividation));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionDividation+1));
                    result=operand1/operand2;

                    listUpdater(listOfSymbols,listOfOperands,currentPositionDividation,result);
                }

            }
            else if(listOfSymbols.contains('-') || listOfSymbols.contains('+'))
            {
                int currentPositionSubstraction=listOfSymbols.indexOf('-');
                int currentPositionAddition=listOfSymbols.indexOf('+');

                if((currentPositionSubstraction<currentPositionAddition && currentPositionSubstraction!=-1) || currentPositionAddition==-1)
                {
                    operand1=Float.parseFloat(listOfOperands.get(currentPositionSubstraction));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionSubstraction+1));
                    result=operand1-operand2;

                    listUpdater(listOfSymbols,listOfOperands,currentPositionSubstraction,result);
                }
                else if((currentPositionSubstraction>currentPositionAddition && currentPositionAddition!=-1) || currentPositionSubstraction==-1)
                {

                    operand1=Float.parseFloat(listOfOperands.get(currentPositionAddition));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionAddition+1));
                    result=operand1+operand2;

                    listUpdater(listOfSymbols,listOfOperands,currentPositionAddition,result);
                }

            }
            operationCount--;
        }

        Iterator<String> iterator=listOfOperands.iterator();

        String finalResult="";

        while(iterator.hasNext())
        {
            finalResult=iterator.next();
        }

        return Float.parseFloat(finalResult);
    }
}
