package BankSystem;
public class BankCard{
    //instance variables are declared with private access modifier
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;

    /*parameterized constructor is created where clientName is set to an empty string
    while other parameter values are assigned to their instance variables*/
    public BankCard(double balanceAmount, int cardId, String bankAccount,  String issuerBank){
        this.clientName="";
        this.balanceAmount=balanceAmount;
        this.cardId=cardId;
        this.bankAccount=bankAccount;
        this.issuerBank=issuerBank;
    }

    //Since every attribute is restrained with private access modifier so each one has a accessor method to provide its value
    public int getCardId(){
        return this.cardId;
    }

    public String getClientName(){
        return this.clientName;
    }

    public String getIssuerBank(){
        return this.issuerBank;
    }

    public String getBankAccount(){
        return this.bankAccount;
    }

    public double getBalanceAmount(){
        return this.balanceAmount;
    }

    //clientName and balanceAmount have setter method
    public void setClientName(String clientName){
        this.clientName=clientName;
    }

    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount=balanceAmount;
    }

    /*display method displays the values of every instance variable
    but if clientName is an empty string it displays a message*/
    public void display(){
        System.out.println("cardId:"+ this.cardId);
        System.out.println("issuerBank: " + this.issuerBank);
        System.out.println("bankAccount: " + this.bankAccount);
        System.out.println("balanceAmount:"+ this.balanceAmount);
        if(this.clientName==("")){
            System.out.println("Client name is not assigned");
        }else{
            System.out.println("clientName: " + this.clientName);
        }
    }
}
