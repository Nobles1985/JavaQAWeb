package org.example;

class WrongSideException extends Exception{

     public WrongSideException (){

         super("Неверно указана сторона треугольника.");
     }
}
