/**
  * Created by nmupp on 7/30/16.
  */
class TreePractice {

  trait Tree[+A]
  case class Leaf[A](value:A) extends Tree[A]
  case class Branch[A](left:Tree[A],right:Tree[A]) extends Tree[A]

  object Tree {
    def size[A](a:Tree[A]):Int = a match {
      case Leaf(value) => 1
      case Branch(left,right) => 1 + size(left) + size(right)
    }
  }
  val a = Branch[Int](Branch(Leaf(8),Leaf(10)),Branch(Leaf(11),Leaf(12)))

  Tree.size(a)

}
