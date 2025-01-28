package myapp;
import java.util.HashSet;
class Customer{
    String email;
    Integer id;
    public Customer(String email, Integer id) {
        this.email = email;
        this.id = id;
    }
    @Override
    public boolean equals(Object s){
        if(this == s ) return true;
        if(s == null || getClass() != s.getClass()) return false;

        Customer cus = (Customer) s;
        return id == cus.id && email.equals(cus.email);
    }
    @Override
    public int hashCode(){
        int res = email.hashCode();
        res = 31*res + id;
        return res;
    }
}
public class Hashcode {
    public static void main(String[] args) {
        HashSet<Customer> cus = new HashSet<>();
        Customer c1 = new Customer("rag@gmail",101);
        Customer c2 = new Customer("rag@gmail",101);
        Customer c3 = new Customer("aks@gmail",102);
        cus.add(c1);
        cus.add(c2);
        cus.add(c3);
        System.out.println(cus.size());
    }
}
