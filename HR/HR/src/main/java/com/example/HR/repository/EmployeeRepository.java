package com.example.HR.repository;

import com.example.HR.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //  Bu anatasyon, bu sınıfın bir Spring veritabanını deposu olduğunu belirtir.
// Veri tabanı ile iletişimi bunun üstünden sağlıyoruz.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

// JPA ---> CRUD işlemleri için gerekli metotları sağlar.
// CRUD (Create Read Update Delete)
