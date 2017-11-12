package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@SuppressWarnings("ConstantConditions")
public class Problem33 implements Problem<Integer> {
    
    @Override
    public Integer getCalculatedSolution() {
        ArrayList<Fraction> curiousFractions = new ArrayList<>();
        
        return range().flatMap(i -> range().map(j -> new Fraction(i, j)))
                .filter(Fraction::isCurious)
                .reduce(Fraction::multiply).get()
                .denominator;
    }
    
    private Stream<Integer> range() {
        return IntStream.rangeClosed(10, 99).boxed();
    }
    
    private static class Fraction {
        private static final Fraction ZERO = new Fraction(0, 1);
        
        final int numerator, denominator;
        
        Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    
        Fraction toLowestCommonTerms() {
            if (this.numerator == 0) return ZERO;
            
            List<Integer> numeratorFactors = Common.factorize(numerator);
            List<Integer> denominatorFactors = Common.factorize(denominator);
            
            Optional<Integer> maybeCommonElement = findCommonElementAndRemoveIfPresent(numeratorFactors, denominatorFactors);
            
            if (maybeCommonElement.isPresent()) {
                Integer commonElement = maybeCommonElement.get();
                return new Fraction(this.numerator / commonElement, this.denominator / commonElement).toLowestCommonTerms();
            } else {
                return this;
            }
        }
        
        private boolean isCurious() {
            if ((this.numerator == this.denominator) ||
                    (this.numerator % 10 == 0 && this.denominator % 10 == 0) ||
                    (this.numerator > this.denominator)
                    ) {
                return false;
            }
            
            List<Integer> numeratorDigits = digits(numerator);
            List<Integer> denominatorDigits = digits(denominator);
            
            Optional<Integer> maybeCommonElement = findCommonElementAndRemoveIfPresent(numeratorDigits, denominatorDigits);
            
            if (maybeCommonElement.isPresent()) {
                return denominatorDigits.get(0) != 0 && this.equals(new Fraction(numeratorDigits.get(0), denominatorDigits.get(0)));
            } else {
                return false;
            }
        }
        
        Fraction multiply(Fraction other) {
            return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator).toLowestCommonTerms();
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Fraction other = ((Fraction) o).toLowestCommonTerms();
            Fraction self = this.toLowestCommonTerms();
            return other.numerator == self.numerator && other.denominator == self.denominator;
        }
        
        private static List<Integer> digits(int number) {
            return new ArrayList<>(asList(number / 10, number % 10));
        }
        
        private static Optional<Integer> findCommonElementAndRemoveIfPresent(List<Integer> first, List<Integer> second) {
            Optional<Integer> maybeCommonElement = first.stream().filter(second::contains).findFirst();
        
            if (maybeCommonElement.isPresent()) {
                Integer element = maybeCommonElement.get();
                first.remove(element);
                second.remove(element);
            }
        
            return maybeCommonElement;
        }
    }
    
    @Override
    public Integer getExpectedSolution() {
        return 100;
    }
}
