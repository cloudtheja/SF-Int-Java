package newfeatures;

// "permits" is optional if all related types in this hierarchy
// are in the same source file!
sealed interface Transporter /*permits Car, Truck, MyBikes*/ {

}

final class Car implements Transporter {}
//non-sealed class Car extends Transporter {} // opens up subtyping!!
//sealed class Car extends Transporter permits X {} // sealed MUST have subtypes, X must exist!

// record is implicitly final
record Truck(int payload) implements Transporter {}

// enums are very close to final, subtypes must be on
// specific instances (they're nested!)
enum MyBikes implements Transporter {
  UNICYCLE {}, BICYCLE;
}

public class SealedStuff {
}
