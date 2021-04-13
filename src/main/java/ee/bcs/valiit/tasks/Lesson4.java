package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Sisesta, mida soovid teha:\n" +
                    "1. Loo konto\n" +
                    "2. Konto saldo\n" +
                    "3. Lae raha\n" +
                    "4. Võta raha\n" +
                    "5. Tee ülekanne\n" +
                    "6. Välju");
            int a = scanner.nextInt();
            scanner.nextLine();
            if (a == 6) {
                break;
            } else if (a == 1) {
                // TODO 1
                // Add command: "createAccount ${accountNr}"
                // this has to store accountNr with 0 balance
                System.out.println("Palun sisesta uus konto number");
                String accountNr = scanner.nextLine();
                System.out.println("Sisesta algsaldo");
                Double balance = scanner.nextDouble();
                scanner.nextLine();
                accountBalanceMap.put(accountNr, balance);
                System.out.println("Uue konto number on " + accountNr + ". Antud konto saldo on: " + accountBalanceMap.get(accountNr) + " EUR");

                // TODO 2
                // Add command: "getBalance ${accountNr}"
                // this has to display account balance of specific acount
            } else if (a == 2) {
                System.out.println("Palun sisesta konto number");
                String accountNr = scanner.nextLine();
                System.out.println("Konto saldo on: " + accountBalanceMap.get(accountNr));

                // TODO 3
                // Add command: "depositMoney ${accountNr} ${amount}
                // this has to add specified amount of money to account
                // You have to check that amount is positive number
            } else if (a == 3) {
                System.out.println("Palun sisesta konto number");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Sisesta summa, mida soovid kanda");
                Double deposit = scanner.nextDouble();
                scanner.nextLine();
                if (deposit > 0) {
                    balance = balance + deposit;
                    System.out.println("Kontol nr: " + accountNr + " on nüüd saldo " + balance);
                }

                // TODO 4
                // Add command: "withdrawMoney ${accountNr} ${amount}
                // This has to remove specified amount of money from account
                // You have to check that amount is positive number
                // You may not allow this transaction if account balance would become negative
            } else if (a == 4) {
                System.out.println("Palun sisesta konto number");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Sisesta summa, mida soovid võtta");
                Double remove = scanner.nextDouble();
                scanner.nextLine();
                if (remove > 0) {
                    if (balance - remove < 0) {
                        System.out.println("Puuduvad vahendid");
                    } else {
                        balance = balance - remove;
                        System.out.println("Kontol nr: " + accountNr + " on nüüd saldo " + balance);
                    }
                }
                // TODO 5
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
            }else if (a == 5) {
                System.out.println("Palun sisesta konto number kust soovid raha kanda");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Palun sisesta konto number kuhu soovid raha kanda");
                String accountNr2 = scanner.nextLine();
                Double balance2 = accountBalanceMap.get(accountNr2);
                System.out.println("Palun sisesta summa mida soovid ülekanda");
                Double ylekanne = scanner.nextDouble();
                scanner.nextLine();
                if (ylekanne > 0) {
                    if (balance - ylekanne < 0) {
                        System.out.println("Puuduvad vahendid");
                    }else {
                        balance -= ylekanne;
                        balance2 += ylekanne;
                        System.out.println("Kontol nr: " + accountNr + " on nüüd saldo " + balance + " EUR ning kontol nr: " + accountNr2 + " on nüüd saldo " + balance2 + " EUR.");
                    }
                }

            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
