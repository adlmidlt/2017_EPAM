package task3;


public interface DepositService {
    String deposit(Long amount, Long userId) throws InsufficientFundsException;
}
