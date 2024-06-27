package com.example.HR.service;

import com.example.HR.model.Employee;
import com.example.HR.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired //Spring bu alanı otomatik olarak inject(enjekte) eder.
    private EmployeeRepository employeeRepository; //orjinali değişmesin diye kopyasını yazıyoruz. mümkünse küçük harfle başlayarak aynısını yazmak projelerde kullanılır.

    // CRUD 'un C(Creat) kısmı
    public Employee hireEmployee(Employee employee) {
        // Yeni bir çalışanı veritabanına kaydeder. ---> .save
        return employeeRepository.save(employee);
    }

    // CRUD 'un R(Read) kısmı
    public List<Employee> getAllEmployees() { //getAllEmployees = bütün çalışanları getir.
        // Tüm çalışanları veri tabanından "findAll" metodu ile kaydeder.
        return employeeRepository.findAll(); // hepsini göre getirir.
    }

    public Optional<Employee> getEmployeeById(Long id) {
        //Belirtilen kimlikteki çalışanı veritabanından getirir.
        return employeeRepository.findById(id); //id'ye göre arar. örneğin ürün barkod numarası

    }

    // CRUD 'un U(Update) kısmı
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // Belirtilen kimllikteki çalışanı güncelleyen metot.

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Çalışan bulunamadı."));
        /*.orElseThrow(() ---> Bu metodun amacı, bir Optional nesnesinin içinde bir değer olup olmadığını kontrol etmektir.
         Eğer değer varsa bu değeri döner, eğer yoksa belirtilen bir exception'ı fırlatır.*/
        // orELse yani if dönhüsünün else kısmı gibi düşünebiliriz. Aradığımız çalışan bulunamadığı durumlarda
        // Kullanıcıya böyle bir metin gösteriyoruz.

        employee.setName(employeeDetails.getName()); // set'in içinde ayarlayıp get ile yenisini çağırıyoruz.
        employee.setPosition(employeeDetails.getPosition());

        return employeeRepository.save(employee);
    }
    // CRUD'un D(Delete) kısmı
    public void fireEmployee(Long id){
        // belirtilen kimlikteki çalışanı silen metottur.
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee is not found."));

    // Silme işlemini yapan "delete" metdounu JPA repository içerisinde çağırarak kullandık.
        employeeRepository.delete(employee);
    }
    //Config --> Configuration



}
