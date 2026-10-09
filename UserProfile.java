package cyclecare;

public class UserProfile {

    private String name;
    private int age;
    private String pronouns;

    public UserProfile(String name, int age, String pronouns) {
        this.name = name;
        this.age = age;
        this.pronouns = pronouns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public void displayProfile() {
        System.out.println();
        System.out.println("--- MY PROFILE ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Pronouns: " + pronouns);
    }
}