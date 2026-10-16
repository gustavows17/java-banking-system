package Classes;

public class Count {

    private final String userName;
    private final String cpf;
    private double balance;
    private double specialCheck = 0;
    private double specialCheckUsed = 0;
    private double feePaid = 0;

    public Count(String userName, String cpf, double inicialBalance){
        this.userName = userName;
        this.cpf = cpf;
        balance = inicialBalance;

        if (balance <= 500) {
            specialCheck = 50;
        } else {
            specialCheck = inicialBalance * 0.5;
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getCpf() {
        return cpf;
    }

    public double getBalance() {
        return balance;
    }

    public double getSpecialCheck() {
        return specialCheck;
    }


    public void depositMoney(double depositValue) {
        if (depositValue <= 0) {
            System.out.println("Valor de depósito inválido!");
            return;
        }

        balance += depositValue;

        if (specialCheckUsed > 0) {
            double fee = specialCheckUsed * 0.20;
            feePaid += fee;
            balance -= fee;
            specialCheckUsed = 0;

            System.out.printf("Taxa de cheque especial cobrada: R$%.2f%n", fee);
        }
        System.out.printf("Saldo atualizado: R$%.2f%n", balance);
    }

    public void withdrawMoney(double withdrawValue) {
        if (withdrawValue <= 0) {
            System.out.println("Valor de saque inválido!");
            return;
        }

        if (withdrawValue > balance + specialCheck) {
            System.out.println("Saldo e limite insuficientes!");
            return;
        }

        balance -= withdrawValue;

        if (balance < 0) {
            specialCheckUsed = Math.abs(balance);
        }

        System.out.printf("Saldo atualizado: %.2f \n", balance);
    }

    public void payBillet(String code, double billetValue) {
        if (billetValue <= 0) {
            System.out.println("Valor do boleto inválido!");
            return;
        }

        if (billetValue > balance + specialCheck) {
            System.out.println("Saldo e limite insuficientes!");
            return;
        }

        balance -= billetValue;

        if (balance < 0) {
            specialCheckUsed = Math.abs(balance);
        }

        System.out.printf("O boleto de código %s, no valor de %.2f foi pago! \n\n", code, billetValue);
        System.out.printf("Saldo atualizado: %.2f \n", balance);

    }

    public boolean isUsingSpecialCheck() {
        return balance < 0;
    }

    public double getSpecialCheckUsed() {
        return specialCheckUsed;
    }

}

