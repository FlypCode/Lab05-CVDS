package edu.eci.cvds.calculadora;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped

public class Calculadora {

private double resModa;
private double resPromedio;
private double resVarianza;
private double resDesvEstandar;
private int cantNum;
private String numeros;
public Calculadora(){
}

private double[] stringToDouble(){
    String[] values = numeros.split(";");
    double[] newValues = new double[values.length];
    for (int i = 0; i < values.length; i++){
        newValues[i] = Double.parseDouble(values[i]);
        cantNum ++;
    }
    return newValues;
}

public double calculateMean(){
    double[] values = stringToDouble();
    double sum = 0;
    for (double value : values) {
        sum += value;
    }
    resPromedio = sum / values.length;
    return resPromedio;
}

public double calculateStandardDeviation(){
    resDesvEstandar = Math.sqrt(calculateVariance());
    return resDesvEstandar;
}

private double PcalculateMean(){
    double[] values = stringToDouble();
    double sum = 0;
    for (double value : values) {
        sum += value;
    }
    return sum / values.length;
}

public double calculateVariance(){
    double[] values = stringToDouble();
    double variance = 0;
    for (double value : values) {
        variance += (value - PcalculateMean()) * (value - PcalculateMean());
    }
    resVarianza = variance / values.length;
    return resVarianza;
}

public double calculateMode(){
    int max = 0;
    double[] values = stringToDouble();
    for (double i : values) {
        int cont = 0;
        for (double j : values) {
            if (i == j) {
                cont++;
            }
        }
        if(cont > max){
            max = cont;
            resModa = i;
        }
    }
    return resModa;
}

public void restart(){
    numeros = "";
    resPromedio = 0;
    resVarianza = 0;
    resDesvEstandar = 0;
    resModa = 0;
    cantNum = 0;
}

public double getResModa() {
    return resModa;
}

public void setResModa(double resModa) {
    this.resModa = resModa;
}

public double getResPromedio() {
    return resPromedio;
}

public void setResPromedio(double resPromedio) {
    this.resPromedio = resPromedio;
}

public double getResVarianza() {
    return resVarianza;
}

public void setResVarianza(double resVarianza) {
    this.resVarianza = resVarianza;
}

public double getResDesvEstandar() {
    return resDesvEstandar;
}

public void setResDesvEstandar(double resDesvEstandar) {
    this.resDesvEstandar = resDesvEstandar;
}

public int getCantNum() {
    return cantNum;
}

public void setCantNum(int cantNum) {
    this.cantNum = cantNum;
}

public String getNumeros() {
    return numeros;
}

public void setNumeros(String numeros) {
    this.numeros = numeros;
}


}
