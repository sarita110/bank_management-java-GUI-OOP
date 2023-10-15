package BankSystem;
//DebitCard is a child class of BankCard
public class DebitCard extends BankCard
{
    //each attribute is described with private access modifier
    private int pinNumber;
    private double withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;

    /*DebitCard is a parameterized constructor that calls constructor of BankCard using super keyword,
    calls setter method of clientName also assigns parameter values to its instance variable*/
    public DebitCard(double balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName, int pinNumber ){
        super(balanceAmount, cardId, bankAccount, issuerBank);
        super.setClientName(clientName);
        this.pinNumber=pinNumber;
        this.hasWithdrawn=false;
    };

    //each attribute has its respective accessor method
    public int getPinNumber() {
        return this.pinNumber;
    }

    public double getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public String getDateOfWithdrawal() {
        return this.dateOfWithdrawal;
    }

    public boolean getHasWithdrawn() {
        return this.hasWithdrawn;
    }

    //withdrawalAmount has a setter method
    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    /*this method lets you withdraw amount and modifies the balanceAmount after withdrawal,
    if correct pin number is set and there if there is sufficient amount to withdraw otherwise displays a message*/
    public void withDraw(double withdrawalAmount, String dateOfWithdrawal, int pinNumber){

        if(pinNumber==this.pinNumber){
            if(withdrawalAmount<=getBalanceAmount()){
                this.withdrawalAmount=withdrawalAmount;
                this.dateOfWithdrawal=dateOfWithdrawal;
                setBalanceAmount(getBalanceAmount()-withdrawalAmount);
                hasWithdrawn=true;
            }else{
                System.out.println("Insufficient amount in your account");
            }
        }else{
            System.out.println("Incorrect pin number");
        }
    }

    /*this display method has same signature as that of BankCard. When hasWithdrawn has true value
    it calls display of BankCard and displays pinNumber, withdrawalAmount and dateOfWithdrawal else only prints balanceAmount*/
    public void display(){
        if(this.hasWithdrawn==false){
            System.out.println("Balance Amount= "+getBalanceAmount());
        }else{
            super.display();
            System.out.println("pin number: "+this.pinNumber);
            System.out.println("withdrawal amount: "+this.withdrawalAmount);
            System.out.println("date of withdrawal: "+this.dateOfWithdrawal);
        }
    }

}
