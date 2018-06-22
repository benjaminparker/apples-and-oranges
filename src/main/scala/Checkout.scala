object Checkout {

  val prices = Map(
    "Apple" -> 60,
    "Orange" -> 25
  )

  val offers = List(appleDiscount, orangeDiscount)

  def totalCost(items: List[String]): Int = cost(items) - discount(items)

  def cost(items: List[String]): Int = items.foldLeft(0)(_ + prices(_))

  def discount(items: List[String]): Int = offers.foldLeft(0)((tot, offer) => tot + offer(items))

  def appleDiscount: List[String] => Int = items => items.count(_ == "Apple") / 2 * prices("Apple")

  def orangeDiscount: List[String] => Int = items => items.count(_ == "Orange") / 3 * prices("Orange")
}
