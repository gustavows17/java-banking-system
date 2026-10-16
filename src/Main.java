import Classes.Count;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========");
        System.out.println("  BANCO  ");
        System.out.printf("========= \n\n");

        System.out.println("Vamos criar uma conta? [S/N]");
        char yesOrNo = sc.nextLine().toUpperCase().charAt(0);


        switch (yesOrNo) {

            case 'S':
                System.out.println("Dígite o seu nome: ");
                String userName = sc.nextLine();
                System.out.println("Dígite seu CPF: ");
                String cpf = sc.nextLine();
                System.out.println("Dígite seu saldo inicial: ");
                var inicialBalance = sc.nextDouble();

                Count newCont = new Count(userName, cpf, inicialBalance);

                char wantContinue = 'S';

                do {

                    System.out.println("Opções: ");
                    System.out.println("1 - Consultar saldo");
                    System.out.println("2 - Consultar cheque especial");
                    System.out.println("3 - Depositar dinheiro");
                    System.out.println("4 - Sacar dinheiro");
                    System.out.println("5 - Pagar um boleto");
                    System.out.println("6 - Verificar se a conta está usando cheque especial");
                    System.out.printf("O que deseja realizar %s?", userName);
                    char answer = sc.next().charAt(0);

                    switch (answer) {

                        case '1':
                            double balance = newCont.returnBalance();
                            System.out.println("Seu saldo: R$ " + balance );
                            break;

                        case '2':
                            double specialCheck = newCont.specialCheckNewValue();
                            System.out.println("Seu cheque especial: R$" + specialCheck);
                            break;

                        case '3':
                            System.out.println("Dígite o valor de depósito: ");
                            var depositValue = sc.nextDouble();

                            newCont.depositMoney(depositValue);
                            break;

                        case '4':
                            System.out.println("Dígite o valor de saque: ");
                            var withdrawValue = sc.nextDouble();

                            newCont.withdrawMoney(withdrawValue);
                            break;

                        case '5':
                            System.out.println("Dígite o código de barras: ");
                            String code = sc.next();
                            System.out.println("Dígite o valor do boleto: ");
                            var billetValue = sc.nextDouble();
                            newCont.payBillet(code, billetValue);
                            break;

                        case '6':
                            if (newCont.isUsingSpecialCheck()) {
                                System.out.println("A conta está usando cheque especial.");
                                System.out.printf("Valor utilizado: R$%.2f%n", newCont.getSpecialCheckUsed());
                            } else {
                                System.out.println("A conta não está ultilizando cheque especial.");
                            }
                            break;


                    }

                    System.out.println("Deseja realizar uma nova operação? [S/N]");
                    wantContinue = sc.next().toUpperCase().charAt(0);

                } while (wantContinue == 'S');

                break;

            case 'N':
                System.out.println("Ok, tenha um ótimo dia!");
                break;

            default:
                System.out.println("Opção inválida!");
        }

        sc.close();

    }

}
