public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(0.0);
        bankAccount.deposit(15000);
        while (true) {
            try {
                bankAccount.withDraw(6000);
                System.out.println("Снято 6000, текущий баланс "
                        + bankAccount.getAmount());
            } catch (LimitException e) {
                try {
                    bankAccount.withDraw(bankAccount.getAmount());
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Исключение " + e.getMessage());
                System.out.println("Максимальная сумма для снятия " + e.getRemainingAmount());
                System.out.println("Cнято " + e.getRemainingAmount());
                System.out.println("Остаток на счете 0");
                break;
            }
        }
    }

}