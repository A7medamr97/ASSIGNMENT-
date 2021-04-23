package com.company;

public class Test {
    public static void main(String[] args) {
            Payment P1 = new Cash(231);
        Payment P2 = new Check( "Ahmed" , "012934" );
        Payment P3 = new Credit("Nadi" , "VISA" , "25/4");
            P1.printBehavior();
            P1.authorizeBehavior();
        P2.printBehavior();
        P2.authorizeBehavior();
        P3.printBehavior();
        P3.authorizeBehavior();
    }
    public static class Payment {
        private float amount;
        public IauthorizeBehavior authorizeBehavior;
        public IprintBehavior printBehavior;
            public Payment(){}
        public void printBehavior() {
            printBehavior.printReceipt();
        }
        public void authorizeBehavior(){
            authorizeBehavior.authorized();
        }
    }
    public static class Cash extends Payment {
        private float cashTendered;

        public Cash(float amount) {
            this.cashTendered = amount;
                    authorizeBehavior = new AuthorizeNon();
                        printBehavior = new PrintCashTrans();

            }
        }

        public static class Check extends Payment {
            private String name;
            private String bankID;

            public Check(String n1, String bID1) {
                this.name = n1;
                this.bankID = bID1;
                authorizeBehavior = new AuthorizeCheck();
                printBehavior = new PrintNon();
            }

        }
        public static class Credit extends Payment{
        String name , type , expDate;
            public Credit(String name1 ,String type1 , String expDate1){
                    this.name = name1;
                    this.type = type1;
                    this.expDate = expDate1;
                authorizeBehavior = new AuthorizeCredit1();
                printBehavior = new PrintCashTrans();
            }

        }

    public interface IauthorizeBehavior {
        public void authorized();
    }

    public static class AuthorizeCheck implements IauthorizeBehavior {
        public void authorized() {
            System.out.println("Check Authorized ");
        }
    }

    public static  class AuthorizeCredit1 implements IauthorizeBehavior {
        public void authorized() {
            System.out.println("Credit1  Authorized ");
        }
    }

    public static class AuthorizeNon implements IauthorizeBehavior {
        public void authorized() {
            System.out.println(" Non Authorize " );
        }

    }
    public static class AuthorizeCredit2 implements IauthorizeBehavior {

        public void authorized() {
            System.out.println("Credit2 Authorized ");
        }
    }

    public interface IprintBehavior {
        public void printReceipt();
    }
    public static class PrintNon implements IprintBehavior {
        public void printReceipt() {
            System.out.println("print non");
        }
    }
        public static class PrintCashTrans implements IprintBehavior{
            public void printReceipt() {
                System.out.println("Print Trans");
            }
        }
    }



