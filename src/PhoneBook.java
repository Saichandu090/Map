public class PhoneBook
{
    private String name;
    private int age;
    private long phoneNumber;
    private String place;

    PhoneBook(String name, int age, long phoneNumber, String place)
    {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.place = place;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString()
    {
        return "Details [" +
                "Name :'" + name + '\'' +
                ", Age :" + age +
                ", PhoneNumber :" + phoneNumber +
                ", Place :'" + place + '\'' +
                ']';
    }
}
