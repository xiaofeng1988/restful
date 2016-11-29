package hxk.model;

/**
 * @author Administrator
 * @description
 *2015-4-11  上午10:31:10
 */
public class Student {
    private int age;
    private String name;
    
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public static Student getStudent(String name){
	Student student = new Student();
	student.setName(name);
	student.setAge(25);
	return student;
    }
    
}
