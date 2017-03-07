package lambschool;

public interface Criterion<E> {

    boolean test(E s);
    static<E> Criterion<E> invert(Criterion<E> crit) {
        return x -> !crit.test(x);
    }
}
