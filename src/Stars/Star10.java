package Stars;//iven an integer n. You need to recreate the pattern given below for any value of N. Let's say for N = 5, the pattern should look like as below:
//*
//**
//***
//****
//*****
//****
//***
//**
//*
import java.util.Scanner;

public class Star10 {
    public void patt(int N){
        for (int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");

            }
            System.out.println("");
        }

        for (int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                System.out.print("*");

            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Star10 s = new Star10();
        s.patt(N);
    }
}
