package lambda;

import org.junit.Test;

/**
 * @author zyx
 */
public class Lambda1 {
    @Test
    public void abc(){
        Person p = new Person();
        p.setName("abc");
        System.out.println(use(p::getName));
    }





    public String use(Printable p){
        return p.print("abc");
    }
}
interface Printable{
    String print(String s1);
}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String s) {
        return "abxuashdias";
    }
}