package Intro;
class MyRun implements Runnable{

    public void run(){
                     
    }

}


class MyThread extends Thread{
     
    // we can give the name via constructor
    public MyThread(String name){
          super(name);

          setPriority(MIN_PRIORITY);
    }
    public void run(){

        int count=1;
        while (true) {
            
            System.out.println(count++);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
    }


}

class TestThread extends Thread{

   

    public void run(){
       
        int count=1;
        while (true) {
            System.out.println(count++  + "Test thread");
            
        }
    }
}

public interface TestThread03{

    public static void main(String[] args) {

        // Testing  consturctor

        // Thread t=new Thread(new MyRun(),"My Run");



        // MyThread myThread=new MyThread("My Thread");
        // myThread.start();

        // myThread.interrupt();

        // all the getter and setter method

        // System.out.println(myThread.getId());
        // System.out.println(" Name: "+myThread.getName());
        // System.out.println("Priority  : "+myThread.getPriority());
        // System.out.println("state: "+myThread.getState());
        // myThread.start();
        // System.out.println("start : "+myThread.getState());
        // System.out.println("isAlive : "+myThread.isAlive());
        // System.out.println(" isDaemon : "+myThread.isDaemon());




        //  Deamon thread,Yeild thread ,join method

        TestThread testThread=new TestThread();
        testThread.setDaemon(true);
        testThread.start();



        // try{
        //     Thread.sleep(10);;
        // }catch(Exception exception){
        //     exception.printStackTrace();;
        // }


        // JOIN THE MAIN METHOD 
        // Thread mainThread=Thread.currentThread();
        // try {
        //     mainThread.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        //  yeild Thread
     
        int count=1;
        while (true) {{}
            System.out.println(count++ + "Main method");

            Thread.yield();
        }

    }
}
