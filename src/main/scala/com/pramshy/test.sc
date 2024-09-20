//


//recursion and tail recursion
import scala.annotation.tailrec
import scala.language.postfixOps
def factorial(n: BigInt) = {
  @tailrec
  def _fact(n: BigInt, accumulator: BigInt): BigInt = {
    if(n == 1) 1
    else _fact(n-1, accumulator*n)
  }

  _fact(n, 1)
}
factorial(10000)

// method overloading
def add(a: Int, b: Int) = a + b
def add(a: Int, b: Double)= a + b:Double

// default agr
def double(a:Int = 1) = 2*a
double()
double(2)

// name argument
add(b = 10, a = 2)

// is instance of / as instance of
val a: Any = "Hello"
val b: String = if a.isInstanceOf[String] then a.asInstanceOf[String] else ""

// parameterized types
def decide(b: Boolean, x: Any, y: Any) = if (b) x else y
println(decide(true, "A", "B"))
println(decide(true, 10, 20))

def test[T](in: T) = in
val aa:Double = test(1.0)
val bb:String = test("Hello")