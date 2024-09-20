import scala.beans.BeanProperty

class Department(depId: Int, val depName: String)
class Employee(@BeanProperty val firstName: String, val lastName: String, @BeanProperty var department: Department)

val ada = new Employee("Ada", "Lovelace", new Department(1, "Computer Science"))
ada.department = new Department(1, "Applied Mathematics")
println(ada.firstName)
println(ada.department.depName)

// Constructor
class Car (val name: String, val model:String, val color: String, val country: String){
  require(name.nonEmpty,"Car name is required!")
  require(model.nonEmpty, "Car Model is required!")
  def this(name: String, model: String, color: String) = this(name: String, model: String, color: String, "India")
 def changeColor(newColor: String) = new Car(name, model, newColor, country)
}

val car1 = new Car("MM", "XX", "red")
car1.color
val car2 = car1.changeColor("blue")
car2.color

class HtmlNode(val name: String) {
  def getParent(): String = {
    "Parent"
  }
}
class AnchorTag(name: String) extends HtmlNode(name: String) {
  override def getParent(): String = super.getParent()
}

val node: HtmlNode = new AnchorTag("a")

// Case Classes
case class TestCaseClass(content: String) {}

val obj = TestCaseClass("Hello !!")
val name = obj match {
  case TestCaseClass(n) => n
  case _  => "Unknown"
}
println(name)

val TestCaseClass(content) = obj
println(content)

// Abstract Classes

