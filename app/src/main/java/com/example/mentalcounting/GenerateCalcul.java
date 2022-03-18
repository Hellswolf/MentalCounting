package com.example.mentalcounting;

public class GenerateCalcul {

    int firstNumber;
    int secondNumber;
    String typeOfOperation;
    static int point;
    static int total;
    static int i;
    static int iC;


    public GenerateCalcul(int firstNumber, int secondNumber, String typeOfOperation) {

        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.typeOfOperation = typeOfOperation;
    }

    public String generateCalcul() {
        return "Resolvez ce calcul : " + firstNumber + typeOfOperation + secondNumber;
    }

    public int resultCase() {
        int total = 0;
        switch (typeOfOperation) {
            case "+":
                total = firstNumber + secondNumber;
                break;

            case "-":
                total = firstNumber - secondNumber;
                break;

            case "*":
                total = firstNumber * secondNumber;
                break;

            case "/":
                float a = firstNumber / secondNumber;
                total = Math.round(a);
                break;

            default:
                break;
        }
        return total;
    }

    public int getScore() {
        return point;
    }

    // Setter
    public void setScore() {
        i++;
        this.point = i;
    }

    public int getTotalCalcul() {
        return total;
    }

    // Setter
    public void setTotalCalcul() {
        iC++;
        this.total = iC;

    }

}
