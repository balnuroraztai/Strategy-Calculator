# Strategy Design Pattern — Calculator

## Assignment #5 — Software Design Patterns

**Student:** Balnur Oraztay  
**Group:** SE-2524  
**Option:** B — Calculator  
**Language:** Java (JDK 17)

## Project Description

This project demonstrates the Strategy Design Pattern using a simple calculator application in Java.

The calculator supports three mathematical operations: addition, subtraction, and multiplication.

Each operation is implemented as a separate strategy class. The calculator can switch between strategies at runtime without changing its internal implementation.

## Design Pattern

The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each algorithm in a separate class, and makes them interchangeable.

The project contains the following components:

- **Strategy Interface:** `OperationStrategy` — defines the `execute()` method.
- **Concrete Strategies:** `AddStrategy`, `SubtractStrategy`, and `MultiplyStrategy` — implement mathematical operations.
- **Context:** `Calculator` — stores the selected strategy and delegates calculations.
- **Client:** `Main` — creates the calculator and switches between strategies.

## Project Structure

```text
Strategy-Calculator/
├── src/
│   ├── OperationStrategy.java
│   ├── AddStrategy.java
│   ├── SubtractStrategy.java
│   ├── MultiplyStrategy.java
│   ├── Calculator.java
│   └── Main.java
└── README.md
```

## How to Run

1. Make sure Java JDK 17 or later is installed.
2. Open the project in IntelliJ IDEA.
3. Open `Main.java`.
4. Click the Run button next to the `main()` method.

Alternatively, run the program from the terminal:

```bash
javac -d out src/*.java
java -cp out Main
```

## Expected Output

```text
Addition: 15.0
Subtraction: 5.0
Multiplication: 50.0
```

## Runtime Strategy Switching

The calculator changes its behavior using the `setStrategy()` method.

```java
Calculator calculator = new Calculator(new AddStrategy());

System.out.println(calculator.calculate(10, 5));

calculator.setStrategy(new SubtractStrategy());
System.out.println(calculator.calculate(10, 5));

calculator.setStrategy(new MultiplyStrategy());
System.out.println(calculator.calculate(10, 5));
```

The same `Calculator` object performs different mathematical operations without using conditional statements to select an algorithm inside the Context.

## How to Add a New Strategy

To add a new mathematical operation:

1. Create a new Java class that implements `OperationStrategy`.
2. Implement the `execute(double a, double b)` method.
3. Select the new strategy using `setStrategy()` in `Main.java`.

For example, a division strategy could be implemented as follows:

```java
public class DivideStrategy implements OperationStrategy {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
```

This is an optional example. The current project implements only three operations.

## Clean Code Principles

The project demonstrates several Clean Code principles:

- **Single Responsibility Principle:** Each strategy performs one mathematical operation.
- **Meaningful Names:** Classes and methods clearly describe their purposes.
- **Polymorphism Instead of Conditionals:** The Context delegates calculations through the Strategy interface.
- **Dependency on Abstractions:** The Calculator depends on `OperationStrategy` instead of concrete classes.
- **Open/Closed Principle:** New operations can be added without modifying the Calculator class.

## Conclusion

This project demonstrates how the Strategy Design Pattern makes a calculator flexible and easy to extend. By separating mathematical operations into independent classes, the program supports runtime strategy switching and follows Clean Code principles.