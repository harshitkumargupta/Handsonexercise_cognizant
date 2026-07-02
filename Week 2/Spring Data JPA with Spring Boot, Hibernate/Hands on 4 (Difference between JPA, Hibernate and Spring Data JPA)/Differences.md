# Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)
- **What it is**: JPA is a specification (JSR 338) for accessing, persisting, and managing data between Java objects and a relational database.
- **Key aspects**: It is only a set of interfaces and rules. It does not provide any concrete implementation by itself.
- **Purpose**: Provides a standard abstraction so developers aren't tied to a specific ORM implementation.

## Hibernate
- **What it is**: Hibernate is a powerful, high-performance Object-Relational Mapping (ORM) framework for Java. 
- **Relationship to JPA**: It is one of the most popular implementations of the JPA specification.
- **Key aspects**: Provides the actual logic to map Java objects to database tables (via `@Entity`, `@Table`, etc.) and handles the underlying JDBC code, session management, and transaction management.

## Spring Data JPA
- **What it is**: An abstraction layer built on top of JPA (which in most cases uses Hibernate under the hood).
- **Key aspects**: It significantly reduces boilerplate code. Instead of manually writing DAO (Data Access Object) classes with `EntityManager` or `Session` logic, you simply create repository interfaces (like `JpaRepository`).
- **Purpose**: Spring Data JPA automatically provides implementations for common CRUD operations at runtime, making data access significantly faster and easier to implement.

---

### Code Comparison

#### Hibernate (Manual Implementation)
```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
    return employeeID;
}
```

#### Spring Data JPA (Simplified)
```java
// 1. Define Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

// 2. Use in Service
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```
*Notice how Spring Data JPA completely removes the need to manually open sessions, begin transactions, handle rollbacks, and close sessions.*
