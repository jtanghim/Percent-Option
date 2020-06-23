package Calculator;

import java.util.Scanner;

public class Percent {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int warSize, myPotentialBases, oppPotentialBases;
        /**
         * @var myTotalDamage is total damage which opponent inflected on my bases
         * @var oppTotalDamage is total damge which I inflected on the opponent bases
         */
        double myTotalDamage, oppTotalDamage;
        System.out.println("Close war! Looks like you are not sure which is the option to attack...Well " +
                "I can give you a break down of the possibilities");
        System.out.println("Please enter number of bases in the war:");
        warSize = scan.nextInt();
        
        System.out.println("Your side: Please enter number of bases that are not 100% destroyed");
        myPotentialBases = scan.nextInt();
        myTotalDamage = (warSize-myPotentialBases)*100; //To get unavailable bases which we know to be 100% damaged
        
        BaseDescription[] myarr = new BaseDescription[myPotentialBases];
        for(int x=0;x<myPotentialBases;x++){
            myarr[x] = new BaseDescription();
            System.out.println("Please enter partially damaged base "+ (x+1) + " standing in the war");
            myarr[x].setRank(scan.nextInt());
            System.out.println("Please enter % damage this base has");
            myarr[x].setPercentDamage(scan.nextInt());
            myTotalDamage += myarr[x].getPercentDamage();
        }

        System.out.println("Enemy side: Please enter number of enemy bases that are not 100% destroyed");
        oppPotentialBases = scan.nextInt();


        oppTotalDamage = (warSize-oppPotentialBases)*100;

        BaseDescription[] opparr = new BaseDescription[oppPotentialBases];
        for(int y=0;y<oppPotentialBases;y++){
            opparr[y] = new BaseDescription();
            System.out.println("Please enter partially damaged base "+ (y+1) + " standing in the war");
            opparr[y].setRank(scan.nextInt());
            System.out.println("Please enter % damage this base has");
            opparr[y].setPercentDamage(scan.nextInt());
            oppTotalDamage += opparr[y].getPercentDamage();
        }

        calculate(oppTotalDamage,myTotalDamage,opparr);
    }

    /**
     * Analyzes all available bases(not 100% damaged)
     * Lists the base and the required percentage needed to win/tie the war
     * If cannot win/tie, program notifies user that the base is not worth hitting
     * @param oppTotalDamage Total damage opponent's side earned from attacking all your bases
     * @param myTotalDamage Total damage your side earned from attacking the opponents' bases
     * @param arr Array of BaseDescriptions (see Calculator.BaseDescription.java) - populated in the main driver
     */
    public static void calculate(double oppTotalDamage, double myTotalDamage, BaseDescription[] arr){
        double threshold = myTotalDamage-oppTotalDamage; //Greater than threshold will result in higher percentage and a win, equal will result in a tie

        for(int x=0; x<arr.length; x++){
                int availablePercentDamage = 100 - arr[x].getPercentDamage(); // initialized variable to reduce number of fetches
                if (availablePercentDamage > threshold) {
                    System.out.println("Base " + arr[x].getRank() + " requires " + (int)(threshold+arr[x].getPercentDamage()) + "% damage to tie and " + (int)(threshold + 1+arr[x].getPercentDamage()) + "% to win");
                } else if (availablePercentDamage == threshold) {
                    System.out.println("Base " + arr[x].getRank() + " requires " + (int)(threshold +arr[x].getPercentDamage()) + "% damage to tie, cannot win if you hit this base");
                } else {
                    System.out.println("Base " + arr[x].getRank() + " is not worth hitting, cannot win/tie if this base is picked");
                }
        }
    }

}
