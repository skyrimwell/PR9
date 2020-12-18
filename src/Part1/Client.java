package Part1;

public class Client extends INNCheck {
    private String name;
    private String inn;

    public Client(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public String getInn() throws INNException {
        if(inn.length() != 12)
            throw new INNException("Длинна строки должна превышать 12 символов");
        if (!checkKey(inn))
            throw new INNException("Проверочный код не совпал с последними 2мя цифрами!");
        return inn;
    }

    @Override
    public String toString() {
        return "Клиент: " + getName() + " имеет ИНН: " + inn;
    }
}
