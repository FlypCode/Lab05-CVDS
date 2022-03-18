package edu.eci.cvds.GuessBean;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "GuessBean")
@ApplicationScoped


public class GuessBean {
    int randomNumber = (int) (Math.random()*10)+1;
    int score = 110000;
    String status = "Playing";

public int getNumber(){
    return randomNumber;
}

public String getStatus(){
    return status;
}

public int getRandomNumber(){
    return randomNumber;
}

public int getScore(){
    return score;
}

public void setStatus(String newStatus){
    status = newStatus;
}

public void setScore(int newscore){
    score = newscore;
}

public void setRandomNumber(int newrandomNumber){
    randomNumber = newrandomNumber;
}

public String guess(int number){
    if (number == randomNumber){
        setStatus("Win");
        return status;
    }else if (getScore() - 10000 > 0){
        setScore(getScore() - 10000);
        setStatus("Playing");
        return status;
    }else{
        setStatus("Lose");
        return status;
    }

}

public void restart(){
    setRandomNumber((int) (Math.random()*9)+1);
    setScore(110000);
    setStatus("Playing");
}

}
