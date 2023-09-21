package newfeatures;

// intended to be immutable. BUT if the fields are of mutable types... all bets are off!
// stuff in the parens are called "components" from which private final instance fields
// are created/initialized
// records are final types, and cannot "extends" anything (their parent is actually
// java.lang.Record). They CAN implement interfaces
record Customer(String name, int creditLimit) {
  // we're allowed to add arbitrary static fields and methods
  // we're allowed to add arbitrary instance methods (which can access
  // the fields created automatically from the components)
  // we CANNOT declare instance fields

  // if we provide no initialization we get the "canonical" constructor
  // which simply initializes the automatic fields
  // we are allowed to REPLACE the canonical constructor
  // if we do, we MUST use the names of the components as params
//  Customer(String name, int creditLimit) {
//    // could write normalization / validation here
//    this.name = name;
//    this.creditLimit = creditLimit;
//  }

  // if we DO NOT provide canonical constructor we can create "Compact" constructor
  // this provides validation/normalization, and the continues to the canonical one!
  Customer {
    if (name == null || name.length() == 0) throw new IllegalArgumentException();
    name = name.toLowerCase();
    // MUST NOT refer to the FIELDS (this...) here
  }

  Customer(String name) {
    this(name, 1000);
  }

  // are allowed to REPLACE the access methods, must take zero args
  // return the type of the component, and throw no checked exceptions

  // can replace equals, hashCode, toString
  // can use @Override annotation, but NOT super.
  @Override
  public String toString() {
//    return "I'm a customer " + super.toString(); // NO!!
    return "I'm a customer " + name + ", " + creditLimit; // OK
  }
}

public class Record {
  public static void main(String[] args) {
    Customer c1 = new Customer("Fred", 1000);
    Customer c2 = new Customer("Fred", 1000);
    Customer c3 = new Customer("Jim", 2000);

    System.out.println("Customer named " + c1.name() +
      " has credit limit " + c1.creditLimit());

    System.out.println(c1);

    System.out.println("c1.equals(c2) ? " + (c1.equals(c2))); // also hashCode


  }
}
