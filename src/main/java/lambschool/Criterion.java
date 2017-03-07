package lambschool;

public interface Criterion<E> {

    boolean test(E s);
    static<E> Criterion<E> invert(Criterion<E> crit) {
        return x -> !crit.test(x);
    }
    
    static <E> Criterion<E> and(Criterion<E> first, Criterion<E> second) {
        return x -> first.test(x) && second.test(x);
    }

    static <E> Criterion<E> or(Criterion<E> first, Criterion<E> second) {
        return x -> first.test(x) || second.test(x);
    }

    default Criterion<E> invert() {
        return x -> !this.test(x);
    }
    
    default Criterion<E> and(Criterion<E> other) {
        return x -> this.test(x) && other.test(x);
    }

    default Criterion<E> or(Criterion<E> other) {
        return x -> this.test(x) || other.test(x);
    }
}
