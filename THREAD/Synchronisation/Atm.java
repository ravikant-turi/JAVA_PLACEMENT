// package Synchronisation;
class AtmBank{

    synchronized public void CheckBalance(String name){
        System.out.println(name + "checking");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
    }
    synchronized public void  withdrow( String name ,int amount){

        System.out.println(name + "withdrowing");
        try{
            Thread.sleep(1000);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        System.out.println(amount);
    }
     
}
class Customer extends Thread{
       
    AtmBank atmBank;
    String name;
    int amount;

     Customer(String name,AtmBank atmBank,int amount){

        this.amount=amount;
        this.atmBank=atmBank;
        this.name=name;

     }

     public void useAtm(){
        atmBank.CheckBalance(name);
        atmBank.withdrow(name,amount);
     }
     public void run(){
        useAtm();
     }
}

public class Atm {

    public static void main(String[] args) {
        
        AtmBank atmBank=new AtmBank();

        Customer customer1=new Customer("smith",atmBank,1000);
        Customer customer2=new Customer("John", atmBank, 2000);
        customer1.start();
        customer2.start();

    }
    
}
