// package Synchronisation;

class MyData{
     public void display(String data){
        synchronized(this){
            // critical section 
            for(int i=0;i<data.length();i++){
                System.out.print(data.charAt(i));
                try{
                    Thread.sleep(1000);
                }
                catch(Exception exception){
                    exception.printStackTrace();
                }
            }
        }
    }
}


class MyThread1 extends Thread{
    
    MyData d;
    MyThread1(MyData myData){
         this.d=myData;
    }
    public void run(){
         d.display("Hello world"); 
    }
}
class MyThread2 extends Thread{
    
    MyData d;
    MyThread2(MyData myData){
         this.d=myData;
    }
    public void run(){
         d.display("Welcome"); 
    }
}


public class Main {

    public static void main(String[] args) {
       

        MyData myData=new MyData();
        MyThread1 myThread1=new MyThread1(myData);
        MyThread2 myThread2=new MyThread2(myData);

        myThread1.start();
        myThread2.start();
    }
    
}
