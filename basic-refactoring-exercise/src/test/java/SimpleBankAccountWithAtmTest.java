import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private static int FEE = 1;
    private static int DEPOSIT_AMOUNT = 100;
    private static int WITHDRAW_AMOUNT = 70;
    private static int ERRATE_ACCOUNT_ID = 2;
    private static int INITIAL_AMOUNT = 0;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, INITIAL_AMOUNT);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int depositAmountErrateAccount = 50;

        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(ERRATE_ACCOUNT_ID, depositAmountErrateAccount);
        assertEquals(DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - (FEE * 2 ), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(ERRATE_ACCOUNT_ID, WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - FEE, bankAccount.getBalance());
    }
}
