import org.scalatest.{Matchers, WordSpec}

class CheckoutSpec extends WordSpec with Matchers {

  "Checkout" should {

    "produce total cost of zero for no scanned items" in {
      Checkout.totalCost(Nil) shouldEqual 0
    }

    "calculate total cost of 60p for a single apple" in {
      Checkout.totalCost(List("Apple")) shouldEqual 60
    }

    "produce total cost of 25p for a single orange" in {
      Checkout.totalCost(List("Orange")) shouldEqual 25
    }

    "calculate total cost of 120p for three apples" in {
      Checkout.totalCost(List.fill(3)("Apple")) shouldEqual 120
    }

    "produce total cost of 145p for 3 apples and an orange" in {
      Checkout.totalCost(List("Apple", "Apple", "Orange", "Apple")) shouldEqual 145
    }

    "apply buy-one-get-one-free to apples" in {
      Checkout.totalCost(List("Apple", "Apple")) shouldEqual 60
    }

    "apply apple bogof to apples and oranges" in {
      Checkout.totalCost(List("Apple", "Orange", "Apple", "Apple")) shouldEqual 145
    }

    "apply apple bogof and oranges 3 for 2 offers" in {
      Checkout.totalCost(List("Apple", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple")) shouldEqual 170
    }
  }
}
