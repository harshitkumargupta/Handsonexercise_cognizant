-- Exercise 1: Control Structures

-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.
DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60;
BEGIN
    FOR customer_rec IN c_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = customer_rec.LoanID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Promote customer to VIP status based on balance over $10,000.
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
BEGIN
    FOR customer_rec IN c_customers LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Send reminders for loans due within the next 30 days.
DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, c.CustomerName, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan_rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan_rec.CustomerName || 
                             ', your loan ' || loan_rec.LoanID || 
                             ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
