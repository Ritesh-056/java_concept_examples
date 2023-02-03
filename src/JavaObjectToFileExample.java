import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements  Serializable {
   private int empID;
   private String empName;
   private double empSalary;


   public Employee(int emp_id,String emp_name, double emp_salary){
       this.empID = emp_id;
       this.empName =emp_name;
       this.empSalary = emp_salary;
   }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

}



public class JavaObjectToFileExample {

    private  static final String filePath = "/home/ritesh/emp.txt";


    public  void writeToFile(Object serializeObject){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializeObject);
            objectOutputStream.close();
            System.out.println("Data is successfully inserted into the file");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Employee employee = new Employee(101,"Hari Thapa",20000);

        JavaObjectToFileExample javaObjectToFileExample = new JavaObjectToFileExample();
        javaObjectToFileExample.writeToFile(employee);

    }

}
