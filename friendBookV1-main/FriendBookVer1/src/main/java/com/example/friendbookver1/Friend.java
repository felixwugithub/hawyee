package com.example.friendbookver1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.String.valueOf;

public class Friend {

    private String name;
    private int age;


    public Friend(String n, int a){
        name = n;
        age = a;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString(){
        return name;
    }

    public void writeToFile(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(valueOf(age) + "\r");
        bw.write(";" + "\r");
        bw.close();
    }

    public boolean compareFriends(Friend b){
        if(this.name.equals(b.name)){
            return true;
        }
        return false;
    }
}
