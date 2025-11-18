/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shell;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author TOKELO
 */
public class Shell {

    /**
     * @param args the command line arguments
     */
    String host;
        
    public static void main(String[] args) {
        // TODO code application logic here
        
        Shell run = new Shell();
        
        run.start();
    }
    void start(){
        //the beginning of shell
         System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);
        //the input that is meant to be taken from shell
        String input = scanner.nextLine();
        order(input);
    }
    void order(String input){
        //it checks for echo in String
        if(input.contains("echo ")){
           echo(input);
                start(); 
        }else if(input.contains("type ")){
            type(input);
            start();
        }
        switch(input){
            case "exit 0":
                //this stops the program which is trapped in a loop
                System.exit(0);
              
            default:
                //if nothing matches then it will print
                System.out.println(input + ": command not found");
                //this signifys the recursion 
                start();
        }
    }
    
    void echo(String input){
        //the string that is displayed starts at the fiffth index of the string
        String Str = input.substring(5);
        System.out.println(Str);
    }
    void type(String input){
        String Str = input.substring(5);
        
        if(input.endsWith("echo")){
            System.out.println(Str+" is a shell builtin");
        }else if(input.endsWith("exit")){
            System.out.println(Str+" is a shell builtin");
        }else if(input.endsWith("type")){
            System.out.println(Str+" is a shell builtin");
        }else{
            String result = scan(Str);
            if(result==null){
                //if it doesnt find it then it ouputs
                System.out.println(Str+": not found");
              
        }
    } 
            }
        
        
    
    String scan(String Str){
        //This is wat retrieves the input from the terminal as it is a environmental veriable
         String path = System.getenv("PATH");
         //Splits the string when it encounters a : then stores them in a array
         String[] directories = path.split(":");

       //A advanced forloop
           for (String directory : directories) {
           
            Path fullPath = Path.of(directory, Str);
            
            // Check if the program exists and is executable
            if(Files.isRegularFile(fullPath)) {
               String x = Str+" is " + fullPath.toString();
                return x;
            } 
        }
        return null;
        
           
    }
    /**
    void start(){
        //the beginning of shell
         System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);
        //the input that is meant to be taken from shell
        String input = scanner.nextLine();
        order(input);
    }
    void order(String input){
        //it checks for echo in String
        if(input.contains("echo ")){
           echo(input);
                start(); 
        }else if(input.contains("type ")){
            type(input);
            start();
        }
        switch(input){
            case "exit 0":
                //this stops the program which is trapped in a loop
                System.exit(0);
              
            default:
                //if nothing matches then it will print
                System.out.println(input + ": command not found");
                //this signifys the recursion 
                start();
        }
    }
    
    void echo(String input){
        //the string that is displayed starts at the fiffth index of the string
        String Str = input.substring(5);
        System.out.println(Str);
    }
    void type(String input){
         String Str = input.substring(5);
        
        if(input.endsWith("echo")){
            System.out.println(Str+" is a shell builtin");
        }else if(input.endsWith("exit")){
            System.out.println(Str+" is a shell builtin");
        }else if(input.endsWith("type")){
            System.out.println(Str+" is a shell builtin");
        }else{
            System.out.println(Str+": not found");
        }
    }
}
    
    */
}
