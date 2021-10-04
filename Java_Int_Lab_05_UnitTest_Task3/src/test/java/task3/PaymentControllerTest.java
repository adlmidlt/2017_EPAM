package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentControllerTest {

    @InjectMocks // автоматически вводить ложные поля в тестируемый объект.
    private PaymentController paymentController;

    @Mock
    private AccountService accountService;

    @Mock
    private DepositService depositService;

    @BeforeEach
    public void init() throws InsufficientFundsException {
        MockitoAnnotations.initMocks(this); // включаем анотацию программным путем

        when(accountService.isUserAuthenticated(100L)).thenReturn(true);
        when(depositService.deposit(and(lt(100L), gt(0L)),  anyLong())).thenReturn("Success"); // больше чем
        when(depositService.deposit(gt(101L), anyLong())).thenThrow(new InsufficientFundsException()); // меньше чем
    }
    // успешнйы дипозит
    @Test
    public void successfulDeposit() throws InsufficientFundsException {
        assertEquals("Success", depositService.deposit(50L, 100L));
    }
    // дипозит для не прошедшего проверку пользователя
    @Test
    public void depositForUnauthenticatedUser() {
        assertFalse(accountService.isUserAuthenticated(101L));
    }
    // дипозит больше суммы
    @Test
    public void depositOfLargeAmount() {
        Executable executable = () -> paymentController.deposit(150L, 100L);
        assertThrows(InsufficientFundsException.class, executable);
    }

    @Test
    public void depositWrongUserId() {
        Executable executable = () -> paymentController.deposit(50L, 101L);
        assertThrows(SecurityException.class, executable);
    }
}
