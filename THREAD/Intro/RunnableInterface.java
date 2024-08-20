package Intro;
public class RunnableInterface implements Runnable {

    public void run(){

        for(int i=0;i<20;i++){
            System.out.println("i : "+ i);
        }

    }
    public static void main(String[] args) {
        RunnableInterface first=new RunnableInterface();
        Thread thread=new Thread(first);
        thread.start();
        for(int j=0;j<20;j++){
            System.out.println("j : "+ j);
        }
        
    }
    
}
