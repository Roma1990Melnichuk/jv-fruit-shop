package tests;

import core.basesyntax.BalanceOperation;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.OperationStrategy;
import core.basesyntax.OperationStrategyImpl;
import core.basesyntax.PurchaseOperation;
import core.basesyntax.ReturnOperation;
import core.basesyntax.SupplyOperation;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class OperationStrategyTest {
    @Test
    public void testOperationStrategy() {
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        assertInstanceOf(BalanceOperation.class, operationStrategy.getHandler(Operation.BALANCE));
        assertInstanceOf(PurchaseOperation.class, operationStrategy.getHandler(Operation.PURCHASE));
        assertInstanceOf(ReturnOperation.class, operationStrategy.getHandler(Operation.RETURN));
        assertInstanceOf(SupplyOperation.class, operationStrategy.getHandler(Operation.SUPPLY));
    }
}
