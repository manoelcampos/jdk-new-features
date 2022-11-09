package samples.jdk17;

/**
 * A superhero is not a kind of person our project
 * allows to be created. We can only have {@link NaturalPerson} and {@link LegalPerson},
 * as permited by {@link Person} class.
 *
 * <p>If you remove just the // below, you'll see the class does not compile.</p>
 */
public final class SuperHero // extends Person
{
    private String power;
    private String nickname;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

