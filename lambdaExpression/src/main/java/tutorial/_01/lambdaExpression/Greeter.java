package tutorial._01.lambdaExpression;

/**
 * Trida ukazujici, proc je vyuziti lambda vyrazu lepsi, nez starsi zpusoby reseni
 */
public class Greeter {

    public enum GreetingsTypes {
        REGULAR,
        FRIENDLY,
        RUDE
    }

    /**
     * Na zaklade vstupniho parametru se vybira pozdrav - neni elegantni reseni.
     * Lepsim resenim je mit samotne chovani jako argument a na zaklade toho by metoda pracovala.
     */
    public void greet(GreetingsTypes greetingType) {
        switch(greetingType) {
            case REGULAR:
                System.out.println("Hello");
                break;
            case FRIENDLY:
                System.out.println("Hi! I missed you so much!");
                break;
            case RUDE:
                System.out.println("Fuck you");
                break;
            default:
                break;
        }
    }

    /**
     * Metoda, ktera ma jako parametr lambda vyraz, ktery kompletne urcuje jeji chovani.
     */
    public void greet(GreetingLambdaExpression greeting) {
        greeting.greet();;
    }

    /**
     * Druhy a lepsi zpusob je vyuzit polymorfii.
     * Napriklad pouzit iterface greeting, ktery ma metodu greet, kterou musi tridy, ktere jej implementuji
     *     doplnit implementaci.
     * Toto reseni je elegantnejsi, ale pribyly mi 3 nove tridy a 1 interface!
     */
    public void greet(Greeting greeter) {
        greeter.greet();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.greet(GreetingsTypes.REGULAR);
        greeter.greet(new RudeGreeter());

        GreetingLambdaExpression greetings = () -> System.out.println("Hello World");
        greeter.greet(greetings);
        greeter.greet((GreetingLambdaExpression)()->System.out.println("Hi, that's so cool"));
    }
}

/**
 * Interface pro lambda vyrazy. Misto vyuzivani polymorfismu, nebo switche lze vyuzit pouze jeden interface.
 * Ciste a prehledne reseni.
 * Metoda greet definuje chovani. Tudiz funguje, jako kdybychom predavali funkci.
 * Interface musi obsahovat pouze jednu metody se stejnou signaturou, jako ma lambda vyraz.
 */
interface GreetingLambdaExpression {
    void greet();
}