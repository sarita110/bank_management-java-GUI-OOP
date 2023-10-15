package BankSystem;
//CreditCard class is a child class of BankCard
public class CreditCard extends BankCard {
    //each attribute is declared with private access modifier
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    //Parameterized constructor
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, double balanceAmount, int cvcNumber, double interestRate, String expirationDate){
        super(balanceAmount, cardId, bankAccount, issuerBank);
        setClientName(clientName);
        this.cvcNumber=cvcNumber;
        this.interestRate=interestRate;
        this.expirationDate=expirationDate;
        this.isGranted=false;
    }

    //each attribute has its respective accessor method
    public int getCvcNumber(){
        return cvcNumber;
    }

    public double getCreditLimit(){
        return creditLimit;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    public int getGracePeriod(){
        return gracePeriod;
    }

    public boolean getIsGranted(){
        return isGranted;
    }

    /*this method assigns the parameter values to its instance variable if
    creditLimit is less than or equal to 2.5 times the balanceAmount*/
    public void setCreditLimit(double creditLimit, int gracePeriod){
        //getter is used here to access the value of balanceAmount of parent class
        if(creditLimit<=(2.5*getBalanceAmount())){
            this.creditLimit=creditLimit;
            this.gracePeriod=gracePeriod;
            this.isGranted=true;
        }else{
            System.out.println("Your credit cannot be issued");
        }
    }

    //this method resets the values of cvcNumber, creditLimit, gracePeriod to 0 and isGranted is set to false value)
    public void cancelCreditCard(){
        this.cvcNumber=0;
        this.creditLimit=0;
        this.gracePeriod=0;
        this.isGranted=false;
    }

    /*this display method displays values of cvcNumber, interestRate,
    expirationDate and isGranted. If the value of isGranted is true,it will
    call display of super class and will display value of creditLimit and gracePeriod*/
    public void display(){
        if(isGranted==true){
            super.display();
            System.out.println("Credit Limit: "+this.creditLimit);
            System.out.println("Grace Period: "+this.gracePeriod);
        }
        System.out.println("CVC number: "+this.cvcNumber);
        System.out.println("Interest Rate: "+this.interestRate);
        System.out.println("Expiration Date: "+this.expirationDate);
        System.out.println("IS Granted: "+this.isGranted);
    }

}
