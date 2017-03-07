/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EliminateAnonymousClasses;

public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
        
    }
     public void sayHello() {
         class EnglishGreeting implements HelloWorld {
             String name = "world";
             @Override
             public void greet() {
                 greetSomeone("world");
                 
             }
             @Override
             public void greetSomeone(String someone) {
                 name = someone;
                  System.out.println("Hello " + name);
             }
         }
         HelloWorld englishGreeting = new EnglishGreeting();
         
         class FrenchGreeting implements HelloWorld{
             String name = "tout le monde";
             @Override
             public void greet(){
                 greetSomeone("tout le monde");
                 
             }
             @Override
             public void greetSomeone (String someone){
                 name = someone;
                 System.out.println("Salut" + name);
                 
             }
             
         }
         HelloWorld frenchGreeting = new FrenchGreeting();
         
         class SpanishGreeting implements HelloWorld{
             
             String name = "mundo";
             @Override
             public void greet(){
                 
                 greetSomeone ("mundo");
             }
             @Override
             
             public void greetSomeone (String someone){
                 name = someone;
                 System.out.println("Hola" + name);
             }
     }
         HelloWorld spanishGreeting = new SpanishGreeting();
         
         
         englishGreeting.greet();
         frenchGreeting.greetSomeone("Jacque");
         spanishGreeting.greet();
         
     }
     public static void main (String... args){
         HelloWorldAnonymousClasses myApp
                 =  new HelloWorldAnonymousClasses();
         myApp.sayHello();
     }
    
}
