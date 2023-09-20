package application;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

import java.util.List;
import java.util.Scanner;


public class App1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ====");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("=== TEST 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("=== TEST 3: department insert ====");
        Department newDep = new Department(null, "Guitars");
        departmentDao.insert(newDep);
        System.out.println("Inserted! new department id: " + newDep.getId());

        System.out.println("=== TEST 3: department update ====");
        department = departmentDao.findById(5);
        department.setName("Electric Guitars");
        departmentDao.update(department);
        System.out.println("Successful update!");

        System.out.println("=== TEST 4: department delete ====");
        System.out.print("Id to delete department: ");
        int deleteId = sc.nextInt();
        departmentDao.deleteById(deleteId);
        System.out.println("Delete completed");
    }
}
