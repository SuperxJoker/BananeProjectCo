package bench.cpu;

public class generateSieveOfEratosthenes {

    int wanted;
    // Function to print prime numbers in the range of a given number `n`
    public void generateSieveOfEratosthenes2(int n)
    {
        int[] a = new int[n + 1];

        for (int i = 0; i <= n; i++) {      // initialize all numbers as prime
            a[i] = 1;
        }

        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (a[i] == 1)                  // checks if `i` is prime
            {
                for (int j = 2; i * j <= n; j++) {
                    a[i * j] = 0;           // multiples of `i` are not prime
                }
            }
        }

        /*for (int i = 2; i <= n; i++)
        {
            if (a[i] == 1) {
                System.out.print(i + " ");  // prints primes
            }
        }*/
        int j = 0;
        j = n;
        while (j!=1){
            if(a[j] == 1) {
                //System.out.println(j);
                wanted = j;
                break;
            }
            else j--;
            }
        }

        public int getPrim(){
           return wanted;

        }

        public void setPrim(int newPrim){
            this.wanted = newPrim;
        }

        //System.out.println(n);
    }

