package bench.cpu;


import controllers.FibboController;

public class MyThread implements Runnable {
    private Thread t;
    private String benchType;
    private Object benchClass;
    private int benchInput;

    public MyThread( String benchType, Object benchClass, int benchInput) {
        this.benchType = benchType;
        this.benchClass = benchClass;
        this.benchInput = benchInput;
    }

    public Object getBenchClass() {
        return benchClass;
    }

    public int getBenchInput(){
        return benchInput;
    }

    public void run() {
        try {
            //Algorithm here!!!
            if(this.benchType.equals("DigitsOfPiSpigot")){
                //System.out.println("hey1");
                DigitsOfPiSpigot aux = (DigitsOfPiSpigot) this.benchClass;
                aux.Digits(this.benchInput); //d.Digits(k);
                this.benchClass=aux;
            }else if(this.benchType.equals("eulerDigits")){
                //System.out.println("hey2");
                eulerDigits aux =(eulerDigits) this.benchClass;
                aux.EulerCalc(this.benchInput);//euler.EulerCalc(n);
                this.benchClass=aux;
            }else if(this.benchType.equals("generateSieveOfEratosthenes")){
                //System.out.println("hey3");
                generateSieveOfEratosthenes aux =(generateSieveOfEratosthenes) this.benchClass;
                aux.generateSieveOfEratosthenes2(this.benchInput);//test.generateSieveOfEratosthenes2(k);
                this.benchClass=aux;
            }else if(this.benchType.equals("FibboController")){
                //System.out.println("hey4");
                FibboController aux =(FibboController) this.benchClass;
                aux.Fibbo(this.benchInput);//Fibbo(n);
                this.benchClass=aux;
            }
            Thread.sleep(50);
        }catch (InterruptedException e) {
            System.out.println("Thread " +  benchType + " interrupted.");
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, benchType);
            t.start ();
            try {
                t.join();//program waits for thread t to die
            } catch(Exception ex) {
                System.out.println("Exception has been caught" + ex);
            }
        }
    }
}

