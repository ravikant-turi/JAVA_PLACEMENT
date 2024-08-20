// package InterThreadCommunication;

class MyData{

    int value;
    boolean flag=false;
   synchronized public void set(int v){
        value=v;
        while (flag) {
           try{
            wait();
           } 
           catch(Exception e){
            e.printStackTrace();
           }

        }
        
        value=v;
        flag=true;
        notify();
    }
   synchronized public int get(){
        int x=0;
        while (!flag) {
            try{
             wait();
            } 
            catch(Exception e){
             e.printStackTrace();
            }
        }
        
        x= value;
        flag=false;
        notify();
    
        return x;
    }
}
class Producer extends Thread{

    MyData myData;
    public Producer(MyData data){
        myData=data;
    }
    public void run(){
        int count=1;
        while (count!=30) {
            myData.set(count);
            System.out.println("Producer "+ count);
            count++;

            
        }
    }
}
class Consumer extends Thread{

    MyData myData;
    public Consumer(MyData data){
        myData=data;
    }
    public void run(){
      
        while (true) {
           
            int value=myData.get();
            System.out.println("consumer " +  value);

           
        }
    }
}


public class InterCommunication {

    public static void main(String[] args) {
        MyData myData=new MyData();

        Producer producer=new Producer(myData);
        Consumer consumer=new Consumer(myData);

        producer.start();
        consumer.start();
       
    }
    
}
